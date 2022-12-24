package mk.finki.ukim.lab.dians_markthemarket.hw1.pipeAndFilter;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Pipe<String> pipe = addFiltersToPipe();
        AppropriateValues.initAppropriateMarkets();

        Scanner scanner = new Scanner(new File("src/main/java/mk/finki/ukim/lab/dians_markthemarket/hw1/csv/MarketiStartingTable.csv"));

        try {
            CSVWriter writer = new CSVWriter(new FileWriter("src/main/java/mk/finki/ukim/lab/dians_markthemarket/hw1/csv/MarketiTableFinal.csv"));
            while (scanner.hasNextLine()) {
                String[] line = pipe.runFilter(scanner.nextLine()).split("\n");
                if (line.length == 10)
                    writer.writeNext(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Pipe<String> addFiltersToPipe() {
        Pipe<String> pipe = new Pipe<>();
        ReduceFilter reduce = new ReduceFilter();
        RemoveInvalidTypesOfMarketsFilter removeInvalidTypesOfMarketsFilter = new RemoveInvalidTypesOfMarketsFilter();
        RemoveUnwantedCharacterFilter removeUnwantedCharacterFilter = new RemoveUnwantedCharacterFilter();

        pipe.addFilter(reduce);
        pipe.addFilter(removeInvalidTypesOfMarketsFilter);
        pipe.addFilter(removeUnwantedCharacterFilter);

        return pipe;
    }
}

