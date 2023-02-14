package mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.web;

import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.model.Market;
import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/markets")
public class MarketApiController {
    private final MarketService marketService;

    public MarketApiController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public List<Market> getAllMarkets(@RequestParam(required = false, defaultValue = "Market Name") String name,
                                      @RequestParam(required = false, defaultValue = "Market Type") String type,
                                      @RequestParam(required = false, defaultValue = "Municipality") String municipality,
                                      @RequestParam(required = false, defaultValue = "Rating") String rating) {
        return marketService.findByEverythingLike(name, type, municipality, rating);
    }
}
