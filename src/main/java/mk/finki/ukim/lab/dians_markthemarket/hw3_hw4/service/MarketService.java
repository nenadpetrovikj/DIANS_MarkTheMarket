package mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.service;

import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.model.Market;

import java.util.List;

public interface MarketService {

    List<Market> findAllMarkets();

    List<Market> findByEverythingLike(String name, String type, String municipality, String rating);
}