package lv.reactorcourse.auction;

import java.math.BigDecimal;
import java.math.BigInteger;

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

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
