package frigo.json;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonObjectTest {

    private JsonObject obj1 = new JsonObject();
    private JsonObject obj2 = new JsonObject();

    private JsonObject json = new JsonObject()
            .put("boolean1", true)
            .put("boolean2", false)
            .put("integer1", 1)
            .put("integer2", 2)
            .put("double1", 1.0)
            .put("double2", 2.0)
            .put("object1", obj1)
            .put("object2", obj2)
            .put("string1", "value1")
            .put("string2", "value2");

    @Test
    public void get_works_for_all_field_types() {
        assertThat(json.get("boolean1"), is(true));
        assertThat(json.get("boolean2"), is(false));
        assertThat(json.get("integer1"), is(1));
        assertThat(json.get("integer2"), is(2));
        assertThat(json.get("double1"), is(1.0));
        assertThat(json.get("double2"), is(2.0));
        assertThat(json.get("object1"), sameInstance(obj1));
        assertThat(json.get("object2"), sameInstance(obj2));
        assertThat(json.get("string1"), is("value1"));
        assertThat(json.get("string2"), is("value2"));
    }

    @Test
    public void getString_throws_for_non_strings() {
        assertThrows(JsonException.class, () -> json.getString("boolean1"));
        assertThrows(JsonException.class, () -> json.getString("boolean2"));
        assertThrows(JsonException.class, () -> json.getString("integer1"));
        assertThrows(JsonException.class, () -> json.getString("integer2"));
        assertThrows(JsonException.class, () -> json.getString("double1"));
        assertThrows(JsonException.class, () -> json.getString("double2"));
        assertThrows(JsonException.class, () -> json.getString("object1"));
        assertThrows(JsonException.class, () -> json.getString("object2"));
    }


}
