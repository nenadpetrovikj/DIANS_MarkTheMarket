package mk.finki.ukim.lab.dians_markthemarket.hw3.repository;

import mk.finki.ukim.lab.dians_markthemarket.hw3.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}
