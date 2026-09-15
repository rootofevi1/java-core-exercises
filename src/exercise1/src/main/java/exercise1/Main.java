package exercise1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] coords = new double[6];
        int index = 0;

        while (index < 6) {
            String input = scanner.nextLine().trim();

            if (!input.matches("[-+]?\\d*\\.\\d+")) {
                System.out.println("Could not parse a number. Please, try again");
                index = 0;
                continue;
            }

            try {
                coords[index] = Double.parseDouble(input);
                index++;
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
                index = 0;
            }
        }

        double x1 = coords[0], y1 = coords[1];
        double x2 = coords[2], y2 = coords[3];
        double x3 = coords[4], y3 = coords[5];

        double a = distance(x1, y1, x2, y2);
        double b = distance(x2, y2, x3, y3);
        double c = distance(x3, y3, x1, y1);

        if (a + b > c && a + c > b && b + c > a) {
            double perimeter = a + b + c;
            System.out.printf("Perimeter: %.3f", perimeter);
        } else {
            System.out.println("It's not a triangle");
        }
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
