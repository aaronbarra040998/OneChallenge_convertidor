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
        System.out.println(prompt);
        int option = 1;
        for (Currency currency : currencies) {
            System.out.println(option + ") " + currency.getName());
            option++;
        }
        int selectedOption = getUserInput("Ingrese el número de la opción deseada: ");
        if (selectedOption < 1 || selectedOption > currencies.size()) {
            System.out.println("Opción inválida.");
            return null;
        }
        return currencies.get(selectedOption - 1);
    }

    private int getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}
