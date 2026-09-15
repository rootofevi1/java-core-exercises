package exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        while (true) {
            String input = scanner.nextLine().trim();
            try {
                size = Integer.parseInt(input);
                if (size <= 0) {
                    System.out.println("Input error. Size <= 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }

        double[] numbers = new double[size];
        int index = 0;

        while (index < size) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split("\\s+");
            for (String part : parts) {
                if (index >= size) {
                    break;
                }
                try {
                    numbers[index] = Double.parseDouble(part);
                    index++;
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse a number. Please, try again");
                    break;
                }
            }
        }

        selectionSort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
