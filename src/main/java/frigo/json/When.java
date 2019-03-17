package frigo.json;

import lombok.SneakyThrows;

import java.util.Objects;

public class When {

    public static When When(Object value) {
        return new When(value);
    }

    private Object value;
    private boolean used;

    public When(Object value) {
        this.value = value;
    }

    @SneakyThrows
    public When Case(Object key, Callback callback) {
        if (!used && Objects.equals(value, key)) {
            used = true;
            callback.apply();
        }
        return this;
    }

    @SneakyThrows
    public When Else(Callback callback) {
        if (!used) {
            used = true;
            callback.apply();
        }
        return this;
    }

    @SneakyThrows
    public When Throw() {
        if (!used) {
            used = true;
            throw new IllegalArgumentException("No case to handle " + value);
        }
        return this;
    }

}
