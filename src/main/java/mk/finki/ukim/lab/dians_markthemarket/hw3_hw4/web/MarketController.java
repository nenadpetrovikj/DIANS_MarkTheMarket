package mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.web;

import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/markTheMarket", "/"})
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public String getMarketPage(Model model) {
        model.addAttribute("filteredMarkets", marketService.findAllMarkets());
        return "index";
    }

    @PostMapping("/findAllMarkets")
    public String findAllMarkets(@RequestParam String name, @RequestParam String type, @RequestParam String municipality, @RequestParam String rating, Model model) {
        model.addAttribute("filteredMarkets", marketService.findByEverythingLike(name, type, municipality, rating));
        return "index";
    }
}