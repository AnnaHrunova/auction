package lv.reactorcourse.auction.lots;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
class LotRepresentation {

    private String id;

    private String createdBy;

    private LocalDateTime createdAt;

    private BigDecimal currentPrice;

    LotRepresentation(String id, String createdBy, LocalDateTime createdAt, BigDecimal currentPrice) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.currentPrice = currentPrice;
    }
}
