package exercise;

import java.util.Scanner;

public class Main {

    public static int inputSeconds() {
        Scanner scanner = new Scanner(System.in);
        int seconds = -1;
        while (true) {
            String input = scanner.nextLine();
            try {
                seconds = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
        return seconds;
    }

    public static int[] convertTime(int totalSeconds) {
        if (totalSeconds < 0) {
            return null;
        }
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return new int[]{hours, minutes, seconds};
    }

    public static void printTime(int[] timeParts) {
        if (timeParts == null) {
            System.out.println("Incorrect time");
        } else {
            System.out.printf("%02d:%02d:%02d%n", timeParts[0], timeParts[1], timeParts[2]);
        }
    }

    public static void main(String[] args) {
        int seconds = inputSeconds();
        int[] timeParts = convertTime(seconds);
        printTime(timeParts);
    }
}
