package lv.reactorcourse.auction.model.repositories;

import lv.reactorcourse.auction.model.entities.Bid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BidRepository extends ReactiveMongoRepository<Bid, String> {

    @Query("{ 'lot.id' : ?0 }")
    Flux<Bid> findAllByLotId(String lotId, Pageable pageable);
}
