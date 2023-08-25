public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte TOTAL_PERCENT = 100;
    private long principal;
    private float annualInterestRate;
    private byte paymentPeriod;

    public MortgageCalculator(long principal, float annualInterestRate, byte paymentPeriod) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.paymentPeriod = paymentPeriod;
    }

    public double calculateBalance(short numberOfPaymentsMade) {

        double monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayments = getNumberOfPayments();

        double numerator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade);
        double denominator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;

        return principal * (numerator / denominator);
    }

    public double calculateMortgage() {

        double mortgage;
        double numerator;
        double denominator;

        double monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayments = getNumberOfPayments();

        numerator = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments);
        denominator = Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1;
        mortgage = principal * (numerator / denominator);

        return mortgage;

    }
    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);

        return balances;
    }

    private short getNumberOfPayments() {
        return (short) (paymentPeriod * MONTHS_IN_YEAR);
    }

    private double getMonthlyInterestRate() {
        return (annualInterestRate / TOTAL_PERCENT) / MONTHS_IN_YEAR;
    }

}
