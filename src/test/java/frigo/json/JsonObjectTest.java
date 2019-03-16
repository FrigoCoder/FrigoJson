package frigo.json;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonObjectTest {

    private JsonObject json = new JsonObject();

    @Test
    public void string_fields() {
        json.put("key1", "value1").put("key2", "value2");
        assertThat(json.get("key1"), is("value1"));
        assertThat(json.get("key2"), is("value2"));
        assertThat(json.getString("key1"), is("value1"));
        assertThat(json.getString("key2"), is("value2"));
    }

    @Test
    public void getString_throws_for_non_strings() {
        assertThrows(JsonException.class, () -> new JsonObject().put("key1", 1).getString("key1"));
        assertThrows(JsonException.class, () -> new JsonObject().put("key1", 1.0).getString("key1"));
        assertThrows(JsonException.class, () -> new JsonObject().put("key1", new JsonObject()).getString("key1"));
        assertThrows(JsonException.class, () -> new JsonObject().put("key1", true).getString("key1"));
        assertThrows(JsonException.class, () -> new JsonObject().put("key1", null).getString("key1"));
    }


    @Test
    public void integer_fields() {
        json.put("key1", 1).put("key2", 2);
        assertThat(json.get("key1"), is(1));
        assertThat(json.get("key2"), is(2));
    }

    @Test
    public void double_fields() {
        json.put("key1", 1.0).put("key2", 2.0);
        assertThat(json.get("key1"), is(1.0));
        assertThat(json.get("key2"), is(2.0));
    }

    @Test
    public void object_fields() {
        JsonObject obj1 = new JsonObject();
        JsonObject obj2 = new JsonObject();
        json.put("key1", obj1).put("key2", obj2);
        assertThat(json.get("key1"), is(obj1));
        assertThat(json.get("key2"), is(obj2));
    }

    @Test
    public void boolean_fields() {
        json.put("key1", true).put("key2", false);
        assertThat(json.get("key1"), is(true));
        assertThat(json.get("key2"), is(false));
    }

    @Test
    public void null_field() {
        json.put("key1", null);
        assertThat(json.get("key1"), nullValue());
    }

}
