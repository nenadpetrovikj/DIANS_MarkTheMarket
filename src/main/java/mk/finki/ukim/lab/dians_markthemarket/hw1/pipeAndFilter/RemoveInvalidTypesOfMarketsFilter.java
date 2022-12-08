package mk.finki.ukim.lab.dians_markthemarket.hw1.pipeAndFilter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveInvalidTypesOfMarketsFilter implements Filter<String> {

    private boolean isFirstTime;

    public RemoveInvalidTypesOfMarketsFilter() {
        isFirstTime = true;
    }

    @Override
    public String execute(String input) {
        if (isFirstTime) {
            isFirstTime = false;
            return input;
        } else {
            String[] parts = input.split("\n");
            StringBuilder stringBuilder = new StringBuilder();
            if (parts.length == 10) {
                for (String appropriateValue : AppropriateValues.appropriateMarkets) {
                    if (parts[2].equals(appropriateValue))
                        return stringBuilder.append(Arrays.stream(parts).map(part -> part + "\n").collect(Collectors.joining())).toString();
                }
            }
            return "";
        }
    }
}
