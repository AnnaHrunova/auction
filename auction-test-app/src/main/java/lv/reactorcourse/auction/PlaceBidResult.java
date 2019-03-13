package lv.reactorcourse.auction;

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
