package Ch8.Ch8Lvl2;

public class LoanTest {
    public static void main(String[] args) {
        double amount, rate;
        int period;
        Loan loan;

        // negative amount
        try {
            System.out.println("Entering negative loan amount...");

            amount = -1;
            rate = 10;
            period = 10;

            loan = new Loan(amount, period, rate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            done();
        }

        // negative rate
        try {
            System.out.println("Entering negative interest rate...");

            amount = 10;
            rate = -1;
            period = 10;

            loan = new Loan(amount, period, rate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            done();
        }

        // negative period
        try {
            System.out.println("Entering negative loan period...");

            amount = 10;
            rate = 10;
            period = -1;

            loan = new Loan(amount, period, rate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            done();
        }

        // zero amount
        try {
            System.out.println("Entering zero loan amount...");

            amount = 0;
            rate = 10;
            period = 10;

            loan = new Loan(amount, period, rate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            done();
        }

        // zero period
        try {
            System.out.println("Entering zero loan period...");

            amount = 10;
            rate = 10;
            period = 0;

            loan = new Loan(amount, period, rate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            done();
        }

        // correct conditions
        try {
            System.out.println("Entering correct values...");

            amount = 10000;
            rate = 10;
            period = 10;

            loan = new Loan(amount, period, rate);

            System.out.println("Loan amount: " + loan.getLoanAmount());
            System.out.println("Loan period: " + loan.getPeriod());
            System.out.println("Annual rate: " + loan.getAnnualRate());
            System.out.println("Monthly Rate: " + loan.getMonthlyPayment());
            System.out.println("Total payment: " + loan.getTotalPayment());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            done();
        }
    }

    private static void done() {
        System.out.println("Done.");
        System.out.println();
    }
}
