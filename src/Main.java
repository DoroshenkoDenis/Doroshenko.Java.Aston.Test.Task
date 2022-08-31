import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printPrivet();
        printPrivetName();
        printMultiplesOfNumber();
    }

    static Scanner in = new Scanner(System.in);
    private static String input;
    private static final int EXPECTED_DIGIT = 7;
    private static final String NAME = "Вячеслав";
    private static final double DIGIT = 3;

    /**
     * the method prints "Привет" if the entered number is greater than 7
     */
    public static void printPrivet() {
        System.out.println("Enter a number greater than 7 to say 'Привет'");
        input = in.nextLine();
        boolean statusOK = false;
        while (!statusOK) {
            try {
                while (true) {
                    if (Double.parseDouble(input) > EXPECTED_DIGIT) {
                        System.out.println("Привет");
                        statusOK = true;
                        break;
                    } else {
                        System.out.println("Oooops, This is not what I wanted! Try again...");
                    }
                    input = in.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Oooops, not a digit! Try again: " + e);
                input = in.nextLine();
            }
        }
    }

    /**
     * the method prints "Привет, Вячеслав" if the name "Вячеслав" is entered, otherwise "Нет такого имени"
     */
    public static void printPrivetName() {
        System.out.println("Enter '" + NAME + "' to say 'Привет, Вячеслав'");
        input = in.nextLine();
        while (true) {
            if (input.equals(NAME)) {
                System.out.println("Привет, " + NAME);
                break;
            } else {
                System.out.println("Нет такого имени");
            }
            input = in.nextLine();
        }
    }

    /**
     * the method prints store entered digits to an array and prints all multiples of the passed number
     */
    public static void printMultiplesOfNumber() {
        System.out.println("Enter a digit to add to the array or 'Next' to continue...");
        input = in.nextLine();
        double[] digits = new double[0];
        while (true) {
//  after entering the word 'Next', we display all the numbers in the array that are multiples of the given
            if (input.equalsIgnoreCase("Next")) {
                Arrays.stream(digits).forEach(value -> {
                    if (value % DIGIT == 0) {
                        System.out.println(value);
                    }
                });
//  if the array does not contain multiples of a given number, display a message
                if (Arrays.stream(digits).noneMatch(value -> value % DIGIT == 0)) {
                    System.out.println("Nothing found");
                }
                break;
            } else {
//  the entered numbers are collected in an array
                try {
                    double[] tempArray = new double[digits.length + 1];
                    System.arraycopy(digits, 0, tempArray, 0, digits.length);
                    tempArray[tempArray.length - 1] = Double.parseDouble(input);
                    digits = tempArray;
                    Arrays.stream(digits).forEach(System.out::println);
                    System.out.println("Enter a digit to add to the array or 'Next' to continue...");
                } catch (NumberFormatException e) {
//  exception handles the situation when not a number is entered
                    System.out.println("Oooops, not a digit! Try again or 'Next' to continue...: " + e);
                }
            }
            input = in.nextLine();
        }
    }

}
