package frigo.json;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class JsonObject {

    private Map<String, Object> map = new LinkedHashMap<>();

    public JsonObject put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        Object object = get(key);
        if (clazz.isInstance(object)) {
            return (T) object;
        }
        throw new JsonException(key + " is not " + clazz.toString());
    }

    public boolean getBoolean(String key) {
        return get(key, Boolean.class);
    }

    public double getDouble(String key) {
        return get(key, Double.class);
    }

    public float getFloat(String key) {
        return get(key, Float.class);
    }

    public int getInt(String key) {
        return get(key, Integer.class);
    }

    public JsonObject getJsonObject(String key) {
        return get(key, JsonObject.class);
    }

    public String getString(String key) {
        return get(key, String.class);
    }

    public Set<String> keys() {
        return map.keySet();
    }


}

