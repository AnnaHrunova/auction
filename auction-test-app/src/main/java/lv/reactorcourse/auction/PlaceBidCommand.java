package lv.reactorcourse.auction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PlaceBidCommand {

    private BigInteger userId;

    private String lotId;

    private BigDecimal value;

    public PlaceBidCommand() {
    }

    public PlaceBidCommand(BigInteger userId, String lotId, BigDecimal value) {
        this.userId = userId;
        this.lotId = lotId;
        this.value = value;
    }
}
