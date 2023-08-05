import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte TOTAL_PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the following in the order of the names presented. \nPrincipal: ");
        long principal = scanner.nextLong();
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = (scanner.nextFloat() / TOTAL_PERCENT);
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        System.out.print("Period (Years): ");
        int paymentPeriod = scanner.nextInt() * MONTHS_IN_YEAR;

        double mortgage;
        double numerator;
        double denominator;

        numerator = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), paymentPeriod);
        denominator = Math.pow ((1 + monthlyInterestRate), paymentPeriod) - 1;

        mortgage = principal * ( numerator/denominator );
        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }
}