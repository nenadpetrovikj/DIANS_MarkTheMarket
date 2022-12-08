package mk.finki.ukim.lab.dians_markthemarket.hw1.pipeAndFilter;

public class ReduceFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] parts = input.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (i == 1 || i == 2 || i == 3 || i == 6 || i == 7 || i == 8 || i == 21 || i == 22 || i == 36 || i == 53) {
                stringBuilder.append(parts[i].replace("\"", "")).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
