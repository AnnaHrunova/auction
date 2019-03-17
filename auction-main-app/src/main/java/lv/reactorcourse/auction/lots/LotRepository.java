package lv.reactorcourse.auction.lots;

import lv.reactorcourse.auction.lots.Lot;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LotRepository extends ReactiveMongoRepository<Lot, String> {
}
