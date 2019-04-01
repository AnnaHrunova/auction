package lv.reactorcourse.auction.bids;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceBidCommand {

    private BigInteger userId;

    private String lotId;

    private BigDecimal value;
}
