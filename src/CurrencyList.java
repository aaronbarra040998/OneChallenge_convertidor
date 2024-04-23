import java.util.ArrayList;
import java.util.List;

public class CurrencyList {
    private List<Currency> currencies;

    public CurrencyList() {
        currencies = new ArrayList<>();
        // Agregar las monedas disponibles
        addCurrency("USD", "Dólar");
        addCurrency("ARS", "Peso Argentino");
        addCurrency("PEN", "Sol Peruano");
        addCurrency("BRL", "Real Brasileño");
        addCurrency("COP", "Peso Colombiano");

        // Agregar más monedas si es necesario
    }

    private void addCurrency(String code, String name) {
        currencies.add(new Currency(code, name));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }
}
