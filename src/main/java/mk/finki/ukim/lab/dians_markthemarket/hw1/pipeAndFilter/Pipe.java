package mk.finki.ukim.lab.dians_markthemarket.hw1.pipeAndFilter;

import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    private List<Filter<T>> newList;

    public Pipe() {
        newList = new ArrayList<>();
    }

    public void addFilter(Filter<T> filter) {
        newList.add(filter);
    }

    public T runFilter(T input) {
        for (Filter<T> filter : newList) {
            input = filter.execute(input);
        }
        return input;
    }
}
