import java.util.Arrays;
import java.util.Scanner;

public class MltPrinter {
    private static final double DIGIT = 3;
    private double[] digits = new double[0];
    private final Scanner scanner;
    private String input;

    public MltPrinter(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * the method store entered digits to an array and prints all multiples of the passed number
     * after entering the word 'Next', we display all the numbers in the array that are multiples of the given
     */
    public void printMultiplesOfNumber() {
        printGreeting();
        do {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Next")) { //
                Arrays.stream(digits).forEach(value -> {
                    if (value % DIGIT == 0) {
                        System.out.println((int) value);
                    }
                });
                printNothingFoundNotify();
            } else {
                addDigits();
            }

        } while (!input.equalsIgnoreCase("Next"));
    }

    /**
     * the method collects the entered numbers into an array
     * exception handles the situation when not a number is entered
     */
    private void addDigits() {
        try {
            double[] tempArray = new double[digits.length + 1];
            System.arraycopy(digits, 0, tempArray, 0, digits.length);
            tempArray[tempArray.length - 1] = Double.parseDouble(input);
            digits = tempArray;
            Arrays.stream(digits).forEach(System.out::println);
        } catch (
                NumberFormatException e) {
            System.out.println("Это не цифра: " + e);
        }
    }

    private void printGreeting() {
        System.out.printf("Введите цифру для добавления в массив или 'Next' для вывода чисел кратных %s\n", DIGIT);
    }

    private void printNothingFoundNotify() {
        if (Arrays.stream(digits).noneMatch(value -> value % DIGIT == 0)) {
            System.out.println("Nothing found");
        }
    }

}
