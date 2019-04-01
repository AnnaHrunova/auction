package lv.reactorcourse.auction.bids;

import lv.reactorcourse.auction.lots.Lot;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BidRepository extends ReactiveMongoRepository<Bid, String> {

    Mono<Bid> findFirstByLotOrderByValueDesc(Lot lot);
}
