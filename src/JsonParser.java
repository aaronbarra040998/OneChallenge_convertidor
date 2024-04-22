import com.google.gson.JsonObject;


public class JsonParser {
    public static double parseExchangeRate(String jsonResponse, String targetCurrency) {
        JsonObject jsonObject = com.google.gson.JsonParser.parseString(jsonResponse).getAsJsonObject();
        return jsonObject.getAsJsonObject("conversion_rates").get(targetCurrency).getAsDouble();
    }
}
