import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printPrivet();
    }

    static Scanner in = new Scanner(System.in);
    private static String inputFirstTask = in.nextLine();
    private static final int EXPECTED_DIGIT = 7;

    /**
     * the method prints "Привет" if the entered number is greater than 7
     */
    public static void printPrivet() {
        boolean statusOK = false;
        while (!statusOK) {
            try {
                while (Double.parseDouble(inputFirstTask) > EXPECTED_DIGIT || !inputFirstTask.equalsIgnoreCase("N")) {
                    if (Double.parseDouble(inputFirstTask) > EXPECTED_DIGIT) {
                        System.out.println("Привет");
                        statusOK = true;
                        break;
                    } else if (inputFirstTask.equalsIgnoreCase("N")) {
                        System.exit(0);
                    } else {
                        System.out.println("Oooops, This is not what I wanted! Try again or 'N' to exit");
                    }
                    inputFirstTask = in.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Oooops, not a digit! Try again or 'N' to exit: " + e);
                inputFirstTask = in.nextLine();
            }
        }
    }


}
