package lv.reactorcourse.auction.lots;

import lombok.extern.slf4j.Slf4j;
import lv.reactorcourse.auction.bids.Bid;
import lv.reactorcourse.auction.bids.BidRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;

@Slf4j
@Service
public class LotService {
    private final LotRepository lotRepository;

    private final BidRepository bidRepository;

    public LotService(LotRepository lotRepository, BidRepository bidRepository) {
        this.lotRepository = lotRepository;
        this.bidRepository = bidRepository;
    }

    public Flux<LotRepresentation> getLots() {
        return lotRepository.findAll()
                .flatMap(this::findPrice)
                .map(this::toRepresentation);
    }

    private Mono<Tuple2<Lot, BigDecimal>> findPrice(Lot lot) {
        Mono<BigDecimal> price = bidRepository.findFirstByLotOrderByValueDesc(lot)
                .map(Bid::getValue)
                .switchIfEmpty(Mono.just(BigDecimal.ZERO));

        return Mono.just(lot).zipWith(price);
    }

    private LotRepresentation toRepresentation(Tuple2<Lot, BigDecimal> lotAndPrice) {
        Lot lot = lotAndPrice.getT1();
        BigDecimal price = lotAndPrice.getT2();
        return LotRepresentation.builder()
                .id(lot.getId())
                .createdBy(lot.getCreatedBy().getUsername())
                .createdAt(lot.getCreatedAt())
                .currentPrice(price)
                .build();
    }

}
