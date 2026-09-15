package exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = 0;
        boolean validSize = false;

        while (!validSize) {
            String input = sc.nextLine();
            try {
                size = Integer.parseInt(input.trim());
                if (size <= 0) {
                    System.out.println("Input error. Size <= 0");
                    continue;
                }
                validSize = true;
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }

        int[] numbers = new int[size];
        int count = 0;

        while (count < size) {
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");
            int i = 0;
            while (i < parts.length && count < size) {
                try {
                    numbers[count] = Integer.parseInt(parts[i]);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse a number. Please, try again");
                    break;
                }
                i++;
            }
        }

        int[] matched = new int[size];
        int matchedCount = 0;

        int j = 0;
        while (j < size) {
            if (hasSameFirstAndLastDigit(numbers[j])) {
                matched[matchedCount] = numbers[j];
                matchedCount++;
            }
            j++;
        }

        if (matchedCount == 0) {
            System.out.println("There are no such elements");
        } else {
            int k = 0;
            while (k < matchedCount) {
                System.out.print(matched[k]);
                if (k < matchedCount - 1) {
                    System.out.print(" ");
                }
                k++;
            }
            System.out.println();
        }
    }

    public static boolean hasSameFirstAndLastDigit(int num) {
        num = Math.abs(num);
        int lastDigit = num % 10;
        while (num >= 10) {
            num /= 10;
        }
        int firstDigit = num;
        return firstDigit == lastDigit;
    }
}
