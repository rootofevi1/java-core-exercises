package exercise;

import java.util.Scanner;

public class Main {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            int n;
            try {
                n = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
                continue;
            }

            if (n < 0) {
                System.out.println("Could not parse a number. Please, try again");
                continue;
            }

            if (n > 46) {
                System.out.println("Too large n");
            } else {
                int result = fibonacci(n);
                System.out.println(result);
            }
            break;
        }

        scanner.close();
    }
}
