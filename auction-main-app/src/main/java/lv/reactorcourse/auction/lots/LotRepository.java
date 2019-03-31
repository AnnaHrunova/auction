package lv.reactorcourse.auction.lots;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LotRepository extends ReactiveMongoRepository<Lot, String> {

    Mono<Lot> findFirstById(String id);
}
