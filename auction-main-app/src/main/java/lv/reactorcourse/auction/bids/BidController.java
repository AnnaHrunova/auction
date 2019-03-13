package lv.reactorcourse.auction.bids;

import lv.reactorcourse.auction.bids.dto.BidDto;
import lv.reactorcourse.auction.bids.dto.PlaceBidCommand;
import lv.reactorcourse.auction.bids.dto.PlaceBidResult;
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

    @Autowired
    private BidService bidService;

    @GetMapping("top/{count}/{lotId}")
    public Flux<BidDto> getBids(@PathVariable int count, @PathVariable String lotId) {
        return bidService.findTopByPrice(lotId, count);
    }

    @PostMapping
    public Mono<PlaceBidResult> placeBid(@RequestBody PlaceBidCommand placeBid) {
        return bidService.placeBid(placeBid);
    }

}
