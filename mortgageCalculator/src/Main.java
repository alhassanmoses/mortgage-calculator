import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static final byte MONTHS_IN_YEAR = 12;
    static final byte TOTAL_PERCENT = 100;

    public static void main(String[] args) {

        final String PRINCIPAL_MESSAGE_PROMPT = "Please input the following in the order of the names presented. \nPrincipal ($1K - $10M): ";
        final String ANNUAL_INTEREST_MESSAGE_PROMPT = "Annual Interest Rate: ";
        final String PAYMENT_PERIOD_MESSAGE_PROMPT = "Period (Years): ";

        long principal = (long) readValue(PRINCIPAL_MESSAGE_PROMPT, 1000, 10_000_000);
        float annualInterestRate = (float) readValue(ANNUAL_INTEREST_MESSAGE_PROMPT, 1, 30);
        byte paymentPeriod = (byte) readValue(PAYMENT_PERIOD_MESSAGE_PROMPT, 1, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, paymentPeriod);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("========");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("================");
        for (short month = 1; month <= paymentPeriod * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterestRate, paymentPeriod, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }


    }

    public static double readValue(String prompt, double minValue, double maxValue) {
        Scanner scanner = new Scanner(System.in);
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

    public static double calculateBalance(long principal,
                                          float annualInterestRate,
                                          byte paymentPeriod,
                                          short numberOfPaymentsMade) {

        double monthlyInterestRate = (annualInterestRate / TOTAL_PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (paymentPeriod * MONTHS_IN_YEAR);

        double numerator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade);
        double denominator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;

        return principal * (numerator / denominator);

    }

    public static double calculateMortgage(long principal, float annualInterestRate, byte paymentPeriod) {

        double mortgage;
        double numerator;
        double denominator;

        double monthlyInterestRate = (annualInterestRate / TOTAL_PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (paymentPeriod * MONTHS_IN_YEAR);


        numerator = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments);
        denominator = Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1;

        mortgage = principal * (numerator / denominator);

        return mortgage;

    }
}