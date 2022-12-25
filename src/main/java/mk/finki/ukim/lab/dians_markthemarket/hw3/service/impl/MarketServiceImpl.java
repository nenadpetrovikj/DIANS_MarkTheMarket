package mk.finki.ukim.lab.dians_markthemarket.hw3.service.impl;

import mk.finki.ukim.lab.dians_markthemarket.hw3.model.Market;
import mk.finki.ukim.lab.dians_markthemarket.hw3.repository.MarketRepository;
import mk.finki.ukim.lab.dians_markthemarket.hw3.service.MarketService;
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
}
