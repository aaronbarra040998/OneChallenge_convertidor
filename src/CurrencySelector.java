import java.util.List;
import java.util.Scanner;

public class CurrencySelector {
    private Scanner scanner;
    private CurrencyList currencyList;

    public CurrencySelector() {
        scanner = new Scanner(System.in);
        currencyList = new CurrencyList();
    }

    public Currency selectCurrency(String prompt) {
        List<Currency> currencies = currencyList.getCurrencies();

        while (true) {
            System.out.println(prompt);
            int option = 1;
            for (Currency currency : currencies) {
                System.out.println(option + ") " + currency.getName());
                option++;
            }

            System.out.print("Ingrese el número de la opción deseada: ");

            int selectedOption = getUserInput();
            switch (selectedOption) {
                case 1:
                    return currencies.get(0);
                case 2:
                    return currencies.get(1);
                case 3:
                    return currencies.get(2);
                case 4:
                    return currencies.get(3);
                case 5:
                    return currencies.get(4);
                case 6:
                    System.out.println("Saliendo del programa...");
                    return null;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private int getUserInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Carácter incorrecto. Intente de nuevo.");
            return -1; // Retornar un valor que indique error
        }
    }
}
