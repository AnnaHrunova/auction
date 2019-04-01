package lv.reactorcourse.auction.bids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("bids")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping("top/{lotId}")
    public Mono<BidRepresentation> getTopBid(@PathVariable String lotId) {
        return bidService.findTopBidForLot(lotId);
    }

    @PostMapping
    public Mono<PlaceBidResult> placeBid(@RequestBody PlaceBidCommand placeBid) {
        return bidService.placeBid(placeBid);
    }
}
