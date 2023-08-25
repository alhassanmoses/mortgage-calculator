public class Main {

    public static void main(String[] args) {

        final String PRINCIPAL_MESSAGE_PROMPT = "Please input the following in the order of the names presented. \nPrincipal ($1K - $10M): ";
        final String ANNUAL_INTEREST_MESSAGE_PROMPT = "Annual Interest Rate: ";
        final String PAYMENT_PERIOD_MESSAGE_PROMPT = "Period (Years): ";

        long principal = (long) Console.readValue(PRINCIPAL_MESSAGE_PROMPT, 1000, 10_000_000);
        float annualInterestRate = (float) Console.readValue(ANNUAL_INTEREST_MESSAGE_PROMPT, 1, 30);
        byte paymentPeriod = (byte) Console.readValue(PAYMENT_PERIOD_MESSAGE_PROMPT, 1, 30);

        var mortgageCalculator = new MortgageCalculator(principal, annualInterestRate, paymentPeriod);
        var mortgageReport = new MortgageReport(mortgageCalculator);
        mortgageReport.printMortgage();
        mortgageReport.printBalance();
    }

}