import java.util.Scanner;

public class PrivetMessage {
    private static final int COMPARED_DIGIT = 7;
    private static final String GREETING_MESSAGE = "Ведите цифру больше 7, чтобы сказать 'Привет'";
    private static final String ERROR_MESSAGE = "Это не цифра: ";
    private static final String RESULT_MESSAGE = "Привет";
    private final Scanner scanner;

    public PrivetMessage(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * the method prints "Привет" if the entered number is greater than 7
     */
    public void printPrivet() {
        System.out.println(GREETING_MESSAGE);
        double input = 0;
        do {
            try {
                input = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MESSAGE + e);
            }
        } while (COMPARED_DIGIT >= input);
        System.out.println(RESULT_MESSAGE);
    }

}
