package frigo.json;

import org.junit.jupiter.api.Test;

import static frigo.json.When.When;
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
            .put("float1", 1.0f)
            .put("float2", 2.0f)
            .put("long1", 1L)
            .put("long2", 2L)
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
        assertThat(json.get("float1"), is(1.0f));
        assertThat(json.get("float2"), is(2.0f));
        assertThat(json.get("long1"), is(1L));
        assertThat(json.get("long2"), is(2L));
        assertThat(json.get("object1"), sameInstance(obj1));
        assertThat(json.get("object2"), sameInstance(obj2));
        assertThat(json.get("string1"), is("value1"));
        assertThat(json.get("string2"), is("value2"));
    }

    @Test
    public void getBoolean_returns_boolean_or_throws_for_non_booleans() {
        for (String current : json.keys()) {
            When(current)
                    .Case("boolean1", key -> assertThat(json.getBoolean(key), is(true)))
                    .Case("boolean2", key -> assertThat(json.getBoolean(key), is(false)))
                    .Else((String key) -> assertThrows(JsonException.class, () -> json.getBoolean(key)))
                    .Run();
        }
    }

    @Test
    public void getInt_returns_integer_or_throws_for_non_integers() {
        assertThrows(JsonException.class, () -> json.getInt("boolean1"));
        assertThrows(JsonException.class, () -> json.getInt("boolean2"));
        assertThat(json.getInt("integer1"), is(1));
        assertThat(json.getInt("integer2"), is(2));
        assertThrows(JsonException.class, () -> json.getInt("double1"));
        assertThrows(JsonException.class, () -> json.getInt("double2"));
        assertThrows(JsonException.class, () -> json.getInt("float1"));
        assertThrows(JsonException.class, () -> json.getInt("float2"));
        assertThrows(JsonException.class, () -> json.getInt("object1"));
        assertThrows(JsonException.class, () -> json.getInt("object2"));
        assertThrows(JsonException.class, () -> json.getInt("string1"));
        assertThrows(JsonException.class, () -> json.getInt("string2"));
    }


    @Test
    public void getString_returns_string_or_throws_for_non_strings() {
        assertThrows(JsonException.class, () -> json.getString("boolean1"));
        assertThrows(JsonException.class, () -> json.getString("boolean2"));
        assertThrows(JsonException.class, () -> json.getString("integer1"));
        assertThrows(JsonException.class, () -> json.getString("integer2"));
        assertThrows(JsonException.class, () -> json.getString("double1"));
        assertThrows(JsonException.class, () -> json.getString("double2"));
        assertThrows(JsonException.class, () -> json.getString("float1"));
        assertThrows(JsonException.class, () -> json.getString("float2"));
        assertThrows(JsonException.class, () -> json.getString("object1"));
        assertThrows(JsonException.class, () -> json.getString("object2"));
        assertThat(json.getString("string1"), is("value1"));
        assertThat(json.getString("string2"), is("value2"));
    }


}
