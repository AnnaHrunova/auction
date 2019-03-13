package lv.reactorcourse.auction.model.repositories;

import lv.reactorcourse.auction.model.entities.Lot;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LotRepository extends ReactiveMongoRepository<Lot, String> {
}