package mk.finki.ukim.lab.dians_markthemarket.hw1.pipeAndFilter;

public class RemoveUnwantedCharacterFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] parts = input.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (i == 0 || i == 2 || i == 4 || i == 5) {
                if (parts[i].contains("?") || parts[i].contains("+") || parts[i].equals("nan"))
                    return "";
            }
            stringBuilder.append(parts[i]).append("\n");
        }
        return stringBuilder.toString();
    }
}
