import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the following in the order of the names presented. \nPrincipal: ");
        long principal = scanner.nextLong();
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = (scanner.nextFloat() / 100) / 12;
        System.out.print("Period (Years): ");
        int period = scanner.nextInt() * 12;

        double mortgage;
        double numerator;
        double denominator;

        numerator = annualInterestRate * Math.pow((1 + annualInterestRate), period);
        denominator = Math.pow ((1 + annualInterestRate), period) - 1;

        mortgage = principal * ( numerator/denominator );
        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }
}