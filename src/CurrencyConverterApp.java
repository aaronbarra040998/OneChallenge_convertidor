import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CurrencySelector currencySelector = new CurrencySelector();

            boolean continuar = true;
            while (continuar) {
                Currency baseCurrency = currencySelector.selectCurrency("Seleccione la moneda base:");
                if (baseCurrency == null) {
                    continuar = false;
                    continue;
                }

                double amount = getValidAmountFromUser(scanner);

                Currency targetCurrency = currencySelector.selectCurrency("Seleccione la moneda objetivo:");
                if (targetCurrency == null) {
                    continuar = false;
                    continue;
                }

                String jsonResponse = CurrencyApi.getExchangeRates(baseCurrency.getCode());
                double exchangeRate = JsonParser.parseExchangeRate(jsonResponse, targetCurrency.getCode());
                double convertedAmount = CurrencyConverter.convertCurrency(amount, exchangeRate);

                System.out.println("El monto convertido es: " + convertedAmount + " " + targetCurrency.getCode());

                System.out.println("¿Desea realizar otra conversión? (Sí/No)");
                String respuesta = scanner.nextLine().toLowerCase(); // Convertir la respuesta a minúsculas
                if (respuesta.equals("sí") || respuesta.equals("si")) {
                    continuar = true;
                } else if (respuesta.equals("no")) {
                    continuar = false;
                } else {
                    System.out.println("Respuesta inválida. Saliendo del programa...");
                    continuar = false;
                }
            }

            System.out.println("Gracias por usar el conversor de moneda.");
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Operación interrumpida: " + e.getMessage());
        }
    }

    private static double getValidAmountFromUser(Scanner scanner) {
        double amount = 0;
        boolean montoValido = false;
        while (!montoValido) {
            System.out.print("Ingrese el monto a convertir: ");
            String amountInput = scanner.nextLine();
            try {
                amount = Double.parseDouble(amountInput);
                montoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para el monto.");
            }
        }
        return amount;
    }
}
