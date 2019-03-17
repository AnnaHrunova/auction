package lv.reactorcourse.auction.bids;

import lombok.Data;
import lv.reactorcourse.auction.lots.Lot;
import lv.reactorcourse.auction.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Bid {

    @Id
    private String id;

    @DBRef
    private Lot lot;

    @DBRef
    private User user;

    private BigDecimal value;

    private LocalDateTime createdAt;

    public Bid() {
    }

    public Bid(Lot lot, User user, BigDecimal value, LocalDateTime createdAt) {
        this.lot = lot;
        this.user = user;
        this.value = value;
        this.createdAt = createdAt;
    }
}
