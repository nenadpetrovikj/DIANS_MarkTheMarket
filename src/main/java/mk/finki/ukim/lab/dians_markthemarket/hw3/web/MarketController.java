package mk.finki.ukim.lab.dians_markthemarket.hw3.web;

import mk.finki.ukim.lab.dians_markthemarket.hw3.service.MarkTheMarketInitDatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
@RequestMapping("/markTheMarket")
public class MarketController {

    private final MarkTheMarketInitDatabaseService markTheMarketInitDatabaseService;

    public MarketController(MarkTheMarketInitDatabaseService markTheMarketInitDatabaseService) {
        this.markTheMarketInitDatabaseService = markTheMarketInitDatabaseService;
    }

    @GetMapping
    public String getMarketPage() throws FileNotFoundException {
        markTheMarketInitDatabaseService.createFinal();
        return "index";
    }
}
