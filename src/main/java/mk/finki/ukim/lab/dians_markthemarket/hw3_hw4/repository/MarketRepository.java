package mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.repository;

import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}