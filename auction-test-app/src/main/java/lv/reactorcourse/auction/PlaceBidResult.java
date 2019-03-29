package lv.reactorcourse.auction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PlaceBidResult {

    private boolean accepted;

    public PlaceBidResult(){}

    public PlaceBidResult(boolean accepted) {
        this.accepted = accepted;
    }
}
