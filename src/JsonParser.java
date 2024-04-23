import com.google.gson.JsonObject;

public class JsonParser {
    public static double parseExchangeRate(String jsonResponse, String targetCurrency) {
        try {
            JsonObject jsonObject = com.google.gson.JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.has("conversion_rates")) {
                return jsonObject.getAsJsonObject("conversion_rates").get(targetCurrency).getAsDouble();
            } else {
                throw new IllegalArgumentException("El JSON no contiene las tasas de cambio esperadas.");
            }
        } catch (Exception e) {
            System.err.println("Error al analizar el JSON: " + e.getMessage());
            return -1; // Valor predeterminado para indicar error
        }
    }
}
