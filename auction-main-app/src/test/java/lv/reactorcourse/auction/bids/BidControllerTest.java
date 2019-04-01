package lv.reactorcourse.auction.bids;

import lv.reactorcourse.auction.lots.Lot;
import lv.reactorcourse.auction.lots.LotRepository;
import lv.reactorcourse.auction.user.User;
import lv.reactorcourse.auction.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;
import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BidControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    BidService bidService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LotRepository lotRepository;

    @Test
    public void testCreateTweet() {
        Mono<Lot> lot = lotRepository.save(new Lot());
        Mono<User> user = userRepository.save(new User(new BigInteger("1"), "User"));

        user.zipWith(lot)
                .flatMap(lotAndUser -> bidService.placeBid(createPlaceBidCommand(lotAndUser)));


        lot.doOnNext(l -> webTestClient.get()
                .uri("/bids/top/1/" + l.getId())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(BidRepresentation.class))
        .block();
    }

    private PlaceBidCommand createPlaceBidCommand(Tuple2<User, Lot> lotAndUser) {
        return new PlaceBidCommand(lotAndUser.getT1().getId(), lotAndUser.getT2().getId(), new BigDecimal(0.01));
    }
}
