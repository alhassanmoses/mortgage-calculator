import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readValue(String prompt) {
        return scanner.nextDouble();
    }

    public static double readValue(String prompt, double minValue, double maxValue) {
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= minValue && value <= maxValue)
                break;
            System.out.print("Please enter a number between the ranges: " + minValue + " and " + maxValue + ".");
        }

        return value;
    }
}
