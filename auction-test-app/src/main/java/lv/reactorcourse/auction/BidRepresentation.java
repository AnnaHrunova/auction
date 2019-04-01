package lv.reactorcourse.auction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BidRepresentation {

    private String username;

    private String lotId;

    private BigDecimal value;

    private LocalDateTime placedAt;
}
