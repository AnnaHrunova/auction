package lv.reactorcourse.auction.bids;

import lv.reactorcourse.auction.lots.Lot;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BidRepository extends ReactiveMongoRepository<Bid, String> {

    @Query("{ 'lot.id' : ?0 }")
    Flux<Bid> findAllByLotId(String lotId, Pageable pageable);

    Mono<Bid> findFirstByLotOrderByValueDesc(Lot lot);
}
