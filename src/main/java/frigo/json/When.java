package frigo.json;

import lombok.SneakyThrows;

import java.util.LinkedHashMap;
import java.util.Map;

public class When {

    public static When When(Object value) {
        return new When(value);
    }

    private Object value;
    private Map<Object, WhenHandler> map = new LinkedHashMap<>();
    private WhenHandler otherwise = () -> {
    };

    public When(Object value) {
        this.value = value;
    }

    public <T> When Case(T key, WhenHandler consumer) {
        map.put(key, consumer);
        return this;
    }

    public <T> When Else(WhenHandler consumer) {
        otherwise = consumer;
        return this;
    }

    @SneakyThrows
    public void Run() {
        map.getOrDefault(value, otherwise).apply();
    }

}
