package lv.reactorcourse.auction.config;

import lv.reactorcourse.auction.model.entities.Lot;
import lv.reactorcourse.auction.model.entities.User;
import lv.reactorcourse.auction.model.repositories.LotRepository;
import lv.reactorcourse.auction.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.time.Clock;
import java.time.LocalDateTime;

@Component
public class Initializer {

    private final UserRepository userRepository;

    private final LotRepository lotRepository;

    private final Clock clock;

    @Autowired
    public Initializer(UserRepository userRepository,
                       LotRepository lotRepository,
                       Clock clock) {
        this.userRepository = userRepository;
        this.lotRepository = lotRepository;
        this.clock = clock;
    }

    @PostConstruct
    public void init() {
        Flux.range(0, 1000)
            .flatMap(i -> userRepository.save(new User(BigInteger.valueOf(i), "username" + i)))
            .subscribe();
        userRepository.save(new User(BigInteger.valueOf(-1), "lotCreator"))
                      .flatMap(lotCreator -> lotRepository.save(new Lot(lotCreator, LocalDateTime.now(clock))))
                      .subscribe();
    }

}
