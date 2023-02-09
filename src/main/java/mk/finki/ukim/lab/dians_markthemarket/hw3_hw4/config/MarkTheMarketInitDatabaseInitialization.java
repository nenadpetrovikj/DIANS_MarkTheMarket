package mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.model.Market;
import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.repository.MarketRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class MarkTheMarketInitDatabaseInitialization {

    private final MarketRepository marketRepository;
    private boolean isFirstRow = true;

    public MarkTheMarketInitDatabaseInitialization(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @PostConstruct
    public void createFinal() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/mk/finki/ukim/lab/dians_markthemarket/hw1/csv/MarketiTableFinal.csv"));
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            if (!isFirstRow) {
                marketRepository.save(new Market(line[0].replace("\"", ""),
                        line[1].replace("\"", ""),
                        line[2].replace("\"", ""),
                        line[3].replace("\"", ""),
                        line[4].replace("\"", ""),
                        line[5].replace("\"", ""),
                        line[6].replace("\"", ""),
                        line[7].replace("\"", ""),
                        line[8].replace("\"", ""),
                        line[9].replace("\"", "")));
            }
            isFirstRow = false;
        }
    }
}
