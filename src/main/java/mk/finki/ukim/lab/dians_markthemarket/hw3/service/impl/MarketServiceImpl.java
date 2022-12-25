package mk.finki.ukim.lab.dians_markthemarket.hw3.service.impl;

import mk.finki.ukim.lab.dians_markthemarket.hw3.model.Market;
import mk.finki.ukim.lab.dians_markthemarket.hw3.repository.MarketRepository;
import mk.finki.ukim.lab.dians_markthemarket.hw3.service.MarketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Market> findAllByName(String name) {
        return marketRepository.findAllByNameLike(name);
    }

    @Override
    public List<Market> findAllByNameAndTypeAndMunicipalityLike(String name, String type, String municipality) {
        return marketRepository.findAllByNameAndTypeAndMunicipalityLike(name, type, municipality);
    }

    @Override
    public Market findById(Long id) {
        return marketRepository.findById(id).get();
    }

    @Override
    public List<Market> findByEverythingLike(String name, String type, String municipality, String rating) {
        List<Market> marketsResultList = findAllMarkets();
        if (!name.equals("Market Name")) {
            for (int i = 0; i < marketsResultList.size(); i++) {
                if (!marketsResultList.get(i).getName().contains(name)) {
                    marketsResultList.remove(marketsResultList.get(i--));
                }
            }
        }
        if (!type.equals("Market Type")) {
            for (int i = 0; i < marketsResultList.size(); i++) {
                if (!marketsResultList.get(i).getType().contains(type)) {
                    marketsResultList.remove(marketsResultList.get(i--));
                }
            }
        }
        if (!municipality.equals("Municipality")) {
            for (int i = 0; i < marketsResultList.size(); i++) {
                if (!marketsResultList.get(i).getMunicipality().contains(municipality)) {
                    marketsResultList.remove(marketsResultList.get(i--));
                }
            }
        }
        if (!rating.equals("Rating")) {
            Integer intRating = Integer.parseInt(rating), marketRating = 0;
            String finalRating = "";
            for (int i = 0; i < marketsResultList.size(); i++) {
                if(!marketsResultList.get(i).getRating().equals("")) {
                    if (marketsResultList.get(i).getRating().contains(".")) {
                        finalRating = marketsResultList.get(i).getRating().split("\\.")[0];
                        marketRating = Integer.parseInt(finalRating);
                    } else {
                        marketRating = Integer.parseInt(marketsResultList.get(i).getRating());
                    }
                    if (!marketRating.equals(intRating))
                        marketsResultList.remove(marketsResultList.get(i--));
                }
                else marketsResultList.remove(marketsResultList.get(i--));
            }
        }
        return marketsResultList;
    }

    @Override
    public List<Market> findAllByNameAndTypeAndMunicipalityAndRatingLike(String name, String type, String municipality, String rating) {
        List<Market> markets = marketRepository.findAllByNameAndTypeAndMunicipalityLike(name, type, municipality);
        List<Market> endMarkets = new ArrayList<>();
        Integer intRating = Integer.parseInt(rating);
        Integer marketRating;
        String finalRating = "";
        for (int i = 0; i < markets.size(); i++) {
            Market currMarket = markets.get(i);
            String stringRating = currMarket.getRating();
            if (currMarket.getRating().contains(".")) {
                finalRating = stringRating.split("\\.")[0];
                marketRating = Integer.parseInt(finalRating);
            } else
                marketRating = Integer.parseInt(stringRating);
            if (marketRating.equals(intRating))
                endMarkets.add(currMarket);
        }
        return endMarkets;
    }

}