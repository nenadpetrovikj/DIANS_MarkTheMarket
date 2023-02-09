package mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.service.impl;

import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.model.Market;
import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.repository.MarketRepository;
import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.service.MarketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;

    public MarketServiceImpl(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public List<Market> findAllMarkets() {
        return marketRepository.findAll();
    }

    @Override
    public List<Market> findByEverythingLike(String name, String type, String municipality, String rating) {
        List<Market> marketsResultList = findAllMarkets();
        if (!name.equals("Market Name")) {
            marketsResultList = marketsResultList.stream()
                    .filter(market -> market.getName().contains(name)).toList();
        }

        if (!type.equals("Market Type")) {
            marketsResultList = marketsResultList.stream()
                    .filter(market -> market.getType().contains(type)).toList();
        }

        if (!municipality.equals("Municipality")) {
            marketsResultList = marketsResultList.stream()
                    .filter(market -> market.getMunicipality().contains(municipality)).toList();
        }

        if (!rating.equals("Rating")) {
            int intRating = Integer.parseInt(rating);
            marketsResultList = marketsResultList.stream()
                    .filter(market -> !market.getRating().isEmpty() && Math.round(Float.parseFloat(market.getRating())) == intRating).toList();
        }

        return marketsResultList;
    }
}