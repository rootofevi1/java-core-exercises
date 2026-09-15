package exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        while (true) {
            String input = scanner.nextLine();
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

        int[] arr = new int[size];

        while (true) {
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            if (parts.length == size) {
                // Введены все числа сразу
                boolean ok = true;
                for (int i = 0; i < size; i++) {
                    try {
                        arr[i] = Integer.parseInt(parts[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Could not parse a number. Please, try again");
                        ok = false;
                        break;
                    }
                }
                if (ok) break;
            } else if (parts.length == 1) {
                try {
                    arr[0] = Integer.parseInt(parts[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse a number. Please, try again");
                    continue;
                }
                for (int i = 1; i < size; i++) {
                    while (true) {
                        String nextInput = scanner.nextLine().trim();
                        try {
                            arr[i] = Integer.parseInt(nextInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Could not parse a number. Please, try again");
                        }
                    }
                }
                break;
            } else {
                System.out.println("Could not parse a number. Please, try again");
            }
        }

        int sum = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                sum += arr[i];
                count++;
            }
        }

        if (count == 0) {
            System.out.println("There are no negative elements");
        } else {
            System.out.println(sum / count);
        }

        scanner.close();
    }
}
