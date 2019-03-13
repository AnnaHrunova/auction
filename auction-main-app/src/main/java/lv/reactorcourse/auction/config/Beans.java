package lv.reactorcourse.auction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class Beans {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

}
