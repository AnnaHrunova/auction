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
public class LotRepresentation {

    private String id;

    private String createdBy;

    private LocalDateTime createdAt;

    private BigDecimal currentPrice;
}
