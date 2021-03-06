package lv.reactorcourse.auction.bids;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.reactorcourse.auction.lots.Lot;
import lv.reactorcourse.auction.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bid {

    @Id
    private String id;

    @DBRef
    private Lot lot;

    @DBRef
    private User user;

    private BigDecimal value;

    private LocalDateTime createdAt;
}
