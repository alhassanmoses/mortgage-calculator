import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String PRINCIPAL_MESSAGE_PROMPT ="Please input the following in the order of the names presented. \nPrincipal ($1K - $10M): ";
        final String ANNUAL_INTEREST_MESSAGE_PROMPT="Annual Interest Rate: ";
        final String PAYMENT_PERIOD_MESSAGE_PROMPT= "Period (Years): ";

        long principal = (long) readValue(PRINCIPAL_MESSAGE_PROMPT, 1000, 10_000_000);
        float annualInterestRate = (float) readValue(ANNUAL_INTEREST_MESSAGE_PROMPT,  1, 30);
        byte paymentPeriod = (byte) readValue(PAYMENT_PERIOD_MESSAGE_PROMPT, 1, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, paymentPeriod);

        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }

    public static double readValue(String prompt, double minValue, double maxValue){
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= minValue && value <= maxValue)
                break;
            System.out.print("Please enter a number between the ranges: " + minValue + " and " + maxValue + ".");
        }

        return value;

    }

    public static double calculateMortgage(long principal, float annualInterestRate, byte paymentPeriod ){

        final byte MONTHS_IN_YEAR = 12;
        final byte TOTAL_PERCENT = 100;

        double mortgage;
        double numerator;
        double denominator;

        double monthlyInterestRate = ( annualInterestRate / TOTAL_PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(paymentPeriod * MONTHS_IN_YEAR);


        numerator = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments);
        denominator = Math.pow ((1 + monthlyInterestRate), numberOfPayments) - 1;

        mortgage = principal * ( numerator/denominator );

        return mortgage;

    }
}