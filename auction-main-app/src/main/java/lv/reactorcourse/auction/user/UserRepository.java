package lv.reactorcourse.auction.user;

import lv.reactorcourse.auction.user.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.math.BigInteger;

public interface UserRepository extends ReactiveMongoRepository<User, BigInteger> {
}
