package lv.reactorcourse.auction.bids.dto;

import lombok.Data;

@Data
public class PlaceBidResult {

    private boolean accepted;

    public PlaceBidResult(){}

    public PlaceBidResult(boolean accepted) {
        this.accepted = accepted;
    }
}
