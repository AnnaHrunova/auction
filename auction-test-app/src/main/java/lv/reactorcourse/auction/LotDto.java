package lv.reactorcourse.auction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
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
}
