package exercise;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers;

        while (true) {
            String filePath = scanner.nextLine();

            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                System.out.println("Input error. File doesn't exist");
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
                String line = br.readLine();

                if (line == null) {
                    System.out.println("Input error. Size <= 0");
                    continue;
                }

                int n;
                try {
                    n = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Input error. Size <= 0");
                    continue;
                }

                if (n <= 0) {
                    System.out.println("Input error. Size <= 0");
                    continue;
                }

                List<Double> values = new ArrayList<>();
                String data;
                while ((data = br.readLine()) != null && values.size() < n) {
                    String[] tokens = data.split("\\s+");
                    for (String token : tokens) {
                        if (values.size() >= n) break;
                        try {
                            values.add(Double.parseDouble(token));
                        } catch (NumberFormatException e) {
                        }
                    }
                }

                if (values.size() < n) {
                    System.out.println("Input error. Insufficient number of elements");
                    continue;
                }

                numbers = values.stream().mapToDouble(Double::doubleValue).toArray();

                System.out.println(numbers.length);

                for (int i = 0; i < numbers.length; i++) {
                    System.out.print(numbers[i]);
                    if (i < numbers.length - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                System.out.println("Saving min and max values in file");

                double min = Arrays.stream(numbers).min().getAsDouble();
                double max = Arrays.stream(numbers).max().getAsDouble();

                try (PrintWriter writer = new PrintWriter("result.txt")) {
                    writer.println(min+" "+max);
                }

                break;
            } catch (IOException e) {
                System.out.println("Input error. File doesn't exist");
            }
        }

        scanner.close();
    }
}
