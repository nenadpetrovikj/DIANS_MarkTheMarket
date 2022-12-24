package mk.finki.ukim.lab.dians_markthemarket.hw3.service.impl;

import mk.finki.ukim.lab.dians_markthemarket.hw3.model.Market;
import mk.finki.ukim.lab.dians_markthemarket.hw3.repository.MarketRepository;
import mk.finki.ukim.lab.dians_markthemarket.hw3.service.MarkTheMarketInitDatabaseService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class MarkTheMarketInitDatabaseServiceImpl implements MarkTheMarketInitDatabaseService {

    private final MarketRepository marketRepository;
    private boolean isFirstRow = true;
    private boolean isDatabaseInitialised = false;

    public MarkTheMarketInitDatabaseServiceImpl(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public void createFinal() throws FileNotFoundException {
        if (!isDatabaseInitialised) {
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
        isDatabaseInitialised = true;
    }
}
