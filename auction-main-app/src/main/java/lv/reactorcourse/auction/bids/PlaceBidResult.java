package lv.reactorcourse.auction.bids;

import lombok.Data;

@Data
public class PlaceBidResult {

    private boolean accepted;

    public PlaceBidResult(){}

    public PlaceBidResult(boolean accepted) {
        this.accepted = accepted;
    }
}
