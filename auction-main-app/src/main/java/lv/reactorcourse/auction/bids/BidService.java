package lv.reactorcourse.auction.bids;

import lv.reactorcourse.auction.bids.dto.BidDto;
import lv.reactorcourse.auction.bids.dto.PlaceBidCommand;
import lv.reactorcourse.auction.bids.dto.PlaceBidResult;
import lv.reactorcourse.auction.model.entities.Bid;
import lv.reactorcourse.auction.model.entities.Lot;
import lv.reactorcourse.auction.model.entities.User;
import lv.reactorcourse.auction.model.repositories.BidRepository;
import lv.reactorcourse.auction.model.repositories.LotRepository;
import lv.reactorcourse.auction.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class BidService {

    private static Logger log = Loggers.getLogger(BidService.class);

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Clock clock;

    @Autowired
    private LotRepository lotRepository;

    public Flux<BidDto> findTopByPrice(String lotId, int count) {
        PageRequest pageRequest = PageRequest.of(0, count, Sort.by("value").descending());
        return bidRepository.findAllByLotId(lotId, pageRequest).map(this::toDto);
    }

    public Mono<PlaceBidResult> placeBid(PlaceBidCommand placeBid) {
        PageRequest pageRequest = PageRequest.of(0, 1, Sort.by("value").descending());
        log.debug("place bid request : {}", placeBid);
        return bidRepository
                .findAllByLotId(placeBid.getLotId(), pageRequest)
                .next()
                .flatMap(bid -> addBid(placeBid, bid))
                .switchIfEmpty(createFirstBid(placeBid));
    }

    private Mono<PlaceBidResult> addBid(PlaceBidCommand placeBid, Bid actual) {
        return Mono.just(actual)
                   .filter(bid -> bid.getValue().compareTo(placeBid.getValue()) < 0)
                   .zipWith(userRepository.findById(placeBid.getUserId()))
                   .map(bidAndUser -> fromBidAndUser(bidAndUser, placeBid.getValue()))
                   .flatMap(bidRepository::save)
                   .map(saved -> true)
                   .switchIfEmpty(Mono.just(false))
                   .map(PlaceBidResult::new);
    }

    private Mono<PlaceBidResult> createFirstBid(PlaceBidCommand placeBid) {
        return lotRepository.findById(placeBid.getLotId())
                            .zipWith(userRepository.findById(placeBid.getUserId()))
                            .map(lotAndUser -> fromLotAndUser(lotAndUser, placeBid.getValue()))
                            .flatMap(bidRepository::save)
                            .map(bid -> new PlaceBidResult(true));
    }

    private Bid fromLotAndUser(Tuple2<Lot, User> lotAndUser, BigDecimal value){
        return new Bid(lotAndUser.getT1(), lotAndUser.getT2(), value, LocalDateTime.now(clock));
    }

    private Bid fromBidAndUser(Tuple2<Bid, User> bidAndUser, BigDecimal value){
        return new Bid(bidAndUser.getT1().getLot(), bidAndUser.getT2(), value, LocalDateTime.now(clock));
    }

    private BidDto toDto(Bid bid) {
        return new BidDto(
                bid.getUser().getUsername(),
                bid.getLot().getId(),
                bid.getValue(),
                bid.getCreatedAt()
        );
    }

}
