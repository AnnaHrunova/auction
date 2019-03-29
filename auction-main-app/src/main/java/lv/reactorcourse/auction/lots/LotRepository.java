package lv.reactorcourse.auction.lots;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LotRepository extends ReactiveMongoRepository<Lot, String> {
}
