package exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            System.out.println("Input error");
            return;
        }

        String line = scanner.nextLine();
        int pos = 0;
        int length = line.length();

        boolean hasNumber = false;
        boolean ordered = true;
        int previous = 0;
        int index = 0;
        int violationIndex = -1;

        while (pos < length) {
            while (pos < length && line.charAt(pos) == ' ') pos++;
            if (pos >= length) break;

            char c = line.charAt(pos);
            boolean negative = false;

            if (c == '-') {
                negative = true;
                pos++;
                if (pos >= length || !Character.isDigit(line.charAt(pos))) {
                    break;
                }
            } else if (!Character.isDigit(c)) {
                break;
            }

            int num = 0;
            while (pos < length && Character.isDigit(line.charAt(pos))) {
                num = num * 10 + (line.charAt(pos) - '0');
                pos++;
            }
            if (negative) num = -num;

            if (!hasNumber) {
                hasNumber = true;
                previous = num;
            } else if (ordered) {
                if (num <= previous) {
                    ordered = false;
                    violationIndex = index;
                }
                previous = num;
            }

            index++;

            while (pos < length && line.charAt(pos) == ' ') pos++;
            if (pos < length) {
                char next = line.charAt(pos);
                if (!(Character.isDigit(next) || next == '-' || next == ' ')) {
                    break;
                }
            }
        }

        if (!hasNumber) {
            System.out.println("Input error");
        } else if (ordered) {
            System.out.println("The sequence is ordered in ascending order");
        } else {
            System.out.println("The sequence is not ordered from the ordinal number of the number " + violationIndex);
        }

        scanner.close();
    }
}
