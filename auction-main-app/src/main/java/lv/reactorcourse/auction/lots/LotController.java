package lv.reactorcourse.auction.lots;

import lv.reactorcourse.auction.bids.BidService;
import lv.reactorcourse.auction.bids.BidRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;

@RestController
@RequestMapping("lots")
public class LotController {

    private final LotRepository lotRepository;

    private final BidService bidService;


    @Autowired
    public LotController(LotRepository lotRepository, BidService bidService) {
        this.lotRepository = lotRepository;
        this.bidService = bidService;
    }

    @GetMapping
    public Flux<LotRepresentation> getLots() {
        return lotRepository.findAll()
                            .flatMap(this::findPrice)
                            .map(this::toRepresentation);
    }

    private Mono<Tuple2<Lot, BigDecimal>> findPrice(Lot lot) {
        Mono<BigDecimal> price = bidService.findTopByPrice(lot.getId(), 1)
                                           .next()
                                           .map(BidRepresentation::getValue)
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
