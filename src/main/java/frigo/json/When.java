package frigo.json;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class When implements Consumer<Object> {

    private Map<Object, Consumer<Object>> map = new LinkedHashMap<>();
    private Consumer<Object> otherwise = key -> {
    };

    public <T> When when(T key, Consumer<T> consumer) {
        map.put(key, object -> consumer.accept((T) object));
        return this;
    }

    public <T> When otherwise(Consumer<T> consumer) {
        otherwise = object -> consumer.accept((T) object);
        return this;
    }

    @Override
    public void accept(Object key) {
        map.getOrDefault(key, otherwise).accept(key);
    }

}
