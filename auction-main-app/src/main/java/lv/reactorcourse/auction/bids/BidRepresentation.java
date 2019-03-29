package lv.reactorcourse.auction.bids;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
//@NoArgsConstructor
public class BidRepresentation {

    private String username;

    private String lotId;

    private BigDecimal value;

    private LocalDateTime placedAt;

    public BidRepresentation(){}

    public BidRepresentation(String username, String lotId, BigDecimal value, LocalDateTime placedAt) {
        this.username = username;
        this.lotId = lotId;
        this.value = value;
        this.placedAt = placedAt;
    }
}
