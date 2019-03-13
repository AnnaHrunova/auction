package lv.reactorcourse.auction.model.repositories;

import lv.reactorcourse.auction.model.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.math.BigInteger;

public interface UserRepository extends ReactiveMongoRepository<User, BigInteger> {
}
