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
            for (int i = 0; i < currencies.size(); i++) {
                System.out.println((i + 1) + ") " + currencies.get(i).getName());
            }

            System.out.print("Ingrese el número de la opción deseada: ");
            int selectedOption = getUserInput();

            if (selectedOption >= 1 && selectedOption <= currencies.size()) {
                return currencies.get(selectedOption - 1);
            } else if (selectedOption == currencies.size() + 1) {
                System.out.println("Saliendo del programa...");
                return null;
            } else {
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
