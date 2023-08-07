import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        long principal;
        float annualInterestRate;
        byte paymentPeriod;
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

        System.out.print("Period (Years): ");
        while (true){
            paymentPeriod = scanner.nextByte();
            if (paymentPeriod >=1 && paymentPeriod <=30)
                break;
            System.out.print("Please input a value between 1 - 30.\nPeriod (Years): ");
        }

        double  mortgage = calculateMortgage(principal, annualInterestRate, paymentPeriod);

        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

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