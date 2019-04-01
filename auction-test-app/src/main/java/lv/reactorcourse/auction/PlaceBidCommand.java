package lv.reactorcourse.auction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceBidCommand {

    private BigInteger userId;

    private String lotId;

    private BigDecimal value;
}
