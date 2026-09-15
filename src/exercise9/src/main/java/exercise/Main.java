package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());

        List<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        String substring = scanner.nextLine();

        List<String> filtered = filterLines(lines, substring);

        if (!filtered.isEmpty()) {
            for (int i = 0; i < filtered.size(); i++) {
                System.out.print(filtered.get(i));
                if (i < filtered.size() - 1) {
                    System.out.print(", ");
                }
            }
        }

        scanner.close();
    }

    private static List<String> filterLines(List<String> lines, String substring) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String current = lines.get(i);
            if (current.contains(substring)) {
                result.add(current);
            }
        }
        return result;
    }
}
