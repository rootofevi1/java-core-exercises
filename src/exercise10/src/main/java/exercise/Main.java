package exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        int n;

        while (true) {
            String line = scanner.nextLine();
            try {
                n = Integer.parseInt(line.trim());
                if (n <= 0) {
                    System.out.println("Could not parse a number. Please, try again");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }

        while (users.size() < n) {
            String name = scanner.nextLine();

            Integer age;

            while (true) {
                String ageLine = scanner.nextLine();
                try {
                    age = Integer.valueOf(ageLine.trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse a number. Please, try again");
                }
            }

            if (age <= 0) {
                System.out.print("Incorrect input. Age <= 0");
                continue;
            }

            users.add(new User(name, age));
        }

        String result = users.stream()
                .filter(u -> u.getAge() >= 18)
                .map(User::getName)
                .collect(Collectors.joining(", "));

        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }
}
