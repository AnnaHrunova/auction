package lv.reactorcourse.auction.bids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("bids")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping("top/{count}/{lotId}")
    public Flux<BidRepresentation> getBids(@PathVariable int count, @PathVariable String lotId) {
        return bidService.findTopByPrice(lotId, count);
    }

    @PostMapping
    public Mono<PlaceBidResult> placeBid(@RequestBody PlaceBidCommand placeBid) {
        return bidService.placeBid(placeBid);
    }
}
