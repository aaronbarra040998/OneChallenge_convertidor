import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CurrencySelector currencySelector = new CurrencySelector();

            Currency baseCurrency = currencySelector.selectCurrency("Seleccione la moneda base:");
            if (baseCurrency == null) {
                return;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            Currency targetCurrency = currencySelector.selectCurrency("Seleccione la moneda objetivo:");
            if (targetCurrency == null) {
                return;
            }

            String jsonResponse = CurrencyApi.getExchangeRates(baseCurrency.getCode());
            double exchangeRate = JsonParser.parseExchangeRate(jsonResponse, targetCurrency.getCode());
            double convertedAmount = CurrencyConverter.convertCurrency(amount, exchangeRate);

            System.out.println("El monto convertido es: " + convertedAmount + " " + targetCurrency.getCode());
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener datos de la API: " + e.getMessage());
        }
    }
}
