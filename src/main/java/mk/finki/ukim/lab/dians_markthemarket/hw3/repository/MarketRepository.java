package mk.finki.ukim.lab.dians_markthemarket.hw3.repository;

import mk.finki.ukim.lab.dians_markthemarket.hw3.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findAllByNameAndTypeAndMunicipalityAndRatingLike(String name, String type, String municipality, String description);

    List<Market> findAllByNameLike(String name);

    List<Market> findAllByNameAndTypeAndMunicipalityLike(String name, String type, String municipality);
}