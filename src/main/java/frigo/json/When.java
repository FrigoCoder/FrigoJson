package frigo.json;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class When<T> implements Consumer<T> {

    private Map<T, Consumer<T>> map = new LinkedHashMap<>();
    private Consumer<T> otherwise = (key) -> {
    };

    public When<T> when(T key, Consumer<T> consumer) {
        map.put(key, consumer);
        return this;
    }

    public When<T> otherwise(Consumer<T> consumer) {
        otherwise = consumer;
        return this;
    }

    @Override
    public void accept(T key) {
        map.getOrDefault(key, otherwise).accept(key);
    }

}
