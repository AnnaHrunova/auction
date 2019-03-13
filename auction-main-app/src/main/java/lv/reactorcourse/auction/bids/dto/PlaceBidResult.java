package lv.reactorcourse.auction.bids.dto;

public class PlaceBidResult {

    private boolean accepted;

    public PlaceBidResult(){}

    public PlaceBidResult(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
