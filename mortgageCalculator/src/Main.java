import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte TOTAL_PERCENT = 100;
        long principal;
        float annualInterestRate;
        int paymentPeriod;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input the following in the order of the names presented. \nPrincipal ($1K - $10M): ");
        while (true){
            principal = scanner.nextLong();
            if (principal >= 1000 && principal <= 10_000_000)
                break;

            System.out.print("Please enter a number between the ranges 1,000 - 10,000,000.\nPrincipal ($1K - $10M): ");
        }

        System.out.print("Annual Interest Rate: ");
        while (true){
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30)
                break;
            System.out.print("Please enter a value greater than 0 and less than or equal to 30. \nAnnual Interest Rate: ");
        }
        float monthlyInterestRate = ( annualInterestRate / TOTAL_PERCENT) / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        while (true){
            paymentPeriod = scanner.nextInt();
            if (paymentPeriod >=1 && paymentPeriod <=30)
                break;
            System.out.print("Please input a value between 1 - 30.\n Period (Years): ");
        }
        paymentPeriod *= MONTHS_IN_YEAR;

        double mortgage;
        double numerator;
        double denominator;

        numerator = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), paymentPeriod);
        denominator = Math.pow ((1 + monthlyInterestRate), paymentPeriod) - 1;

        mortgage = principal * ( numerator/denominator );
        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }
}