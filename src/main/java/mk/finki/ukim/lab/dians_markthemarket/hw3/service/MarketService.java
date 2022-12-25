package mk.finki.ukim.lab.dians_markthemarket.hw3.service;

import mk.finki.ukim.lab.dians_markthemarket.hw3.model.Market;

import java.util.List;

public interface MarketService {

    List<Market> findAllMarkets();

    List<Market> findAllByNameAndTypeAndMunicipalityAndRatingLike(String name, String type, String municipality, String rating);

    List<Market> findAllByName(String name);

    List<Market> findAllByNameAndTypeAndMunicipalityLike(String name, String type, String municipality);

    Market findById(Long id);

    List<Market> findByEverythingLike(String name, String type, String municipality, String rating);
}