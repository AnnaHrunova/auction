package lv.reactorcourse.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;

@SpringBootApplication
public class AuctionTestApplication {

    static WebClient client = WebClient.create("http://localhost:8080");

    static Logger log = Loggers.getLogger("test-app");

    public static void main(String[] args) {
        SpringApplication.run(AuctionTestApplication.class, args);

        Flux.interval(Duration.ofSeconds(1))
            .flatMap(iteration -> getLot())
            .flatMap(lot -> getTopBid(lot)
                    .switchIfEmpty(Mono.just(new BidDto(null, lot.getId(), BigDecimal.ZERO, null))))
            .map(bid -> createCommand(bid))
            .flatMap(command -> placeBid(command))
            .subscribe(result -> log.info("bid placed : {}", result.isAccepted()));
    }

    static Mono<LotDto> getLot() {
        return client.get()
                     .uri("lots")
                     .retrieve()
                     .bodyToFlux(LotDto.class)
                     .next();
    }

    static Mono<BidDto> getTopBid(LotDto lot) {
        return client.get()
                     .uri("bids/top/1/" + lot.getId())
                     .retrieve()
                     .bodyToFlux(BidDto.class)
                     .next();
    }

    static PlaceBidCommand createCommand(BidDto bidDto) {
        return new PlaceBidCommand(
                BigInteger.ONE,
                bidDto.getLotId(),
                bidDto.getValue().add(new BigDecimal("0.01"))
        );
    }

    static Mono<PlaceBidResult> placeBid(PlaceBidCommand command) {
        return client.post()
                     .uri("bids")
                     .contentType(MediaType.APPLICATION_JSON)
                     .syncBody(command)
                     .accept(MediaType.APPLICATION_JSON)
                     .retrieve()
                     .bodyToMono(PlaceBidResult.class);
    }

}
