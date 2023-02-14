package mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.model.Market;
import mk.finki.ukim.lab.dians_markthemarket.hw3_hw4.repository.MarketRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Objects;
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
        File file = ResourceUtils.getFile("classpath:data/MarketiTableFinal.csv");
        InputStream in = new FileInputStream(file);
        Scanner scanner = new Scanner(in);
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
