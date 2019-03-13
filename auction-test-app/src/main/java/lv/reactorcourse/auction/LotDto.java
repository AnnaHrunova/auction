package lv.reactorcourse.auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LotDto {

    private String id;

    private String createdBy;

    private LocalDateTime createdAt;

    private BigDecimal currentPrice;

    public LotDto(){}

    public LotDto(String id, String createdBy, LocalDateTime createdAt, BigDecimal currentPrice) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.currentPrice = currentPrice;
    }

    public String getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }
}
