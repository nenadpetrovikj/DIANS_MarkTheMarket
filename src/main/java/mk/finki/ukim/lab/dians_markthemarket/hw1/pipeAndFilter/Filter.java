package mk.finki.ukim.lab.dians_markthemarket.hw1.pipeAndFilter;

public interface Filter<T> {
    T execute(T input);
}
