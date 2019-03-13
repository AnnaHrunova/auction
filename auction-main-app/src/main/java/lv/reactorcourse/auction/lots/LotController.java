package lv.reactorcourse.auction.lots;

import lv.reactorcourse.auction.bids.BidService;
import lv.reactorcourse.auction.bids.dto.BidDto;
import lv.reactorcourse.auction.model.entities.Lot;
import lv.reactorcourse.auction.model.repositories.LotRepository;
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

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private BidService bidService;

    @GetMapping
    public Flux<LotDto> getLots() {
        return lotRepository.findAll()
                            .flatMap(this::findPrice)
                            .map(this::toDto);
    }

    private Mono<Tuple2<Lot, BigDecimal>> findPrice(Lot lot) {
        Mono<BigDecimal> price = bidService.findTopByPrice(lot.getId(), 1)
                                           .next()
                                           .map(BidDto::getValue)
                                           .switchIfEmpty(Mono.just(BigDecimal.ZERO));

        return Mono.just(lot).zipWith(price);
    }

    private LotDto toDto(Tuple2<Lot, BigDecimal> lotAndPrice) {
        Lot lot = lotAndPrice.getT1();
        BigDecimal price = lotAndPrice.getT2();
        return new LotDto(lot.getId(), lot.getCreatedBy().getUsername(), lot.getCreatedAt(), price);
    }

}
