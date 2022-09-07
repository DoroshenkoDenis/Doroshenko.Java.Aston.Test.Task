import java.util.Scanner;

public class PrivetNameMessage {
    private static final String NAME = "Вячеслав";
    private static final String GREETING_MESSAGE = "Введите %s, чтобы сказать 'Привет, %s'\n";
    private static final String ERROR_MESSAGE = "Нет такого имени";
    private static final String RESULT_MESSAGE = "Привет, " + NAME;
    private final Scanner scanner;

    public PrivetNameMessage(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * the method prints "Привет, Вячеслав" if the name "Вячеслав" is entered, otherwise "Нет такого имени"
     */
    public void printPrivetName() {
        System.out.printf(GREETING_MESSAGE, NAME, NAME);
        String input;
        do {
            input = scanner.nextLine();
            if (input.equals(NAME)) {
                System.out.println(RESULT_MESSAGE);
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        } while (!input.equals(NAME));
    }

}
