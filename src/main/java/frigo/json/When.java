package frigo.json;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class When {

    public static When When(Object value) {
        return new When(value);
    }

    private Object value;
    private Map<Object, Consumer<Object>> map = new LinkedHashMap<>();
    private Consumer<Object> otherwise = key -> {
    };

    public When(Object value) {
        this.value = value;
    }

    public <T> When Case(T key, Consumer<T> consumer) {
        map.put(key, object -> consumer.accept((T) object));
        return this;
    }

    public <T> When Else(Consumer<T> consumer) {
        otherwise = object -> consumer.accept((T) object);
        return this;
    }

    public void Run() {
        map.getOrDefault(value, otherwise).accept(value);
    }

}
