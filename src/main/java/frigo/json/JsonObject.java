package frigo.json;

import java.util.LinkedHashMap;
import java.util.Map;

class JsonObject {

    private Map<String, Object> values = new LinkedHashMap<>();

    public JsonObject put(String key, Object value) {
        values.put(key, value);
        return this;
    }

    public Object get(String key) {
        return values.get(key);
    }

    public String getString(String key) {
        Object object = get(key);
        if (object instanceof String) {
            return (String) object;
        }
        throw new JsonException(key + " is not string");
    }


}

