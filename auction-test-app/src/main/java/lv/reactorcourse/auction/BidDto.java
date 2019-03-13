package lv.reactorcourse.auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BidDto {

    private String username;

    private String lotId;

    private BigDecimal value;

    private LocalDateTime placedAt;

    public BidDto(){}

    public BidDto(String username, String lotId, BigDecimal value, LocalDateTime placedAt) {
        this.username = username;
        this.lotId = lotId;
        this.value = value;
        this.placedAt = placedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getLotId() {
        return lotId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }
}
