package lv.reactorcourse.auction.bids;

import lombok.AllArgsConstructor;
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
