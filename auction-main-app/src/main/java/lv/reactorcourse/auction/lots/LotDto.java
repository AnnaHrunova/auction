package lv.reactorcourse.auction.lots;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
class LotDto {

    private String id;

    private String createdBy;

    private LocalDateTime createdAt;

    private BigDecimal currentPrice;

    LotDto(String id, String createdBy, LocalDateTime createdAt, BigDecimal currentPrice) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.currentPrice = currentPrice;
    }
}
