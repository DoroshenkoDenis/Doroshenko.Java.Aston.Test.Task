import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new PrivetMessage(scanner).printPrivet();
        new PrivetNameMessage(scanner).printPrivetName();
        new MltPrinter(scanner).printMultiplesOfNumber();

        scanner.close();

    }

}

