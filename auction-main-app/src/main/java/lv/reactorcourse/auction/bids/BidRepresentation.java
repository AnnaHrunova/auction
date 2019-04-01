package lv.reactorcourse.auction.bids;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidRepresentation {

    private String username;

    private String lotId;

    private BigDecimal value;

    private LocalDateTime placedAt;

}
