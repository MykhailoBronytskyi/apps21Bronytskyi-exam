package json;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    HashMap<String, Json> jsonObject = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair pair: jsonPairs){
            jsonObject.put(pair.key, pair.value);
        }
    }

    @Override
    public String toJson() {
        StringBuilder result = new StringBuilder("{");
        for (String key: jsonObject.keySet()){
            result.append(key).append(": ").append(jsonObject.get(key).toJson()).append(", ");
        }
        result.append("}");

//        String result_str = result.toString();
        int len = result.length();
        if (len == 2){
            return result.toString();
        }

        return result.substring(0, len - 3) + "}";
    }

    public void add(JsonPair jsonPair) {
        jsonObject.put(jsonPair.key,jsonPair.value);
    }

    public boolean contains(String name) {
        return jsonObject.containsKey(name);
    }

    public Json find(String name) {
        return jsonObject.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject newJsonObject = new JsonObject();

        for (String name: names){
            Json value = jsonObject.get(name);

            if (this.contains(name)){
                newJsonObject.add(new JsonPair(name, value));
            }
        }
        return newJsonObject;
    }
}

