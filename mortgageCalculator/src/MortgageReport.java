import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currencyFormatter;
    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        currencyFormatter = NumberFormat.getCurrencyInstance();
    }

    public void printBalance() {

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("================");

        for (double balance : mortgageCalculator.getRemainingBalances())
            System.out.println(currencyFormatter.format(balance));

    }

    public void printMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("========");
        System.out.println("Monthly Payments: " + currencyFormatter.format(mortgage));
    }
}
