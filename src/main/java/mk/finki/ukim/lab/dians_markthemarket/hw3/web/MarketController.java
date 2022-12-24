package mk.finki.ukim.lab.dians_markthemarket.hw3.web;

import mk.finki.ukim.lab.dians_markthemarket.hw3.service.MarkTheMarketInitDatabaseService;
import mk.finki.ukim.lab.dians_markthemarket.hw3.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
@RequestMapping("/markTheMarket")
public class MarketController {

    private final MarkTheMarketInitDatabaseService markTheMarketInitDatabaseService;
    private final MarketService marketService;

    public MarketController(MarkTheMarketInitDatabaseService markTheMarketInitDatabaseService, MarketService marketService) {
        this.markTheMarketInitDatabaseService = markTheMarketInitDatabaseService;
        this.marketService = marketService;
    }

    @GetMapping
    public String getMarketPage() throws FileNotFoundException {
        markTheMarketInitDatabaseService.createFinal();
        return "index";
    }

    @PostMapping("/findAllMarkets")
    public String findAllMarkets(Model model) {
        model.addAttribute("markets", marketService.findAllMarkets());
        return "index";
    }
}
