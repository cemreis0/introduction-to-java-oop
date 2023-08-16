package Ch8.Ch8Lvl2;

class Loan {
    // data members
    private static final int MONTHS_IN_YEAR = 12;
    private double loanAmount;
    private double monthlyInterestRate;
    private int numberOfPayments;

    public Loan(double amount, int period, double rate) {
        setLoanAmount(amount);
        setPeriod(period);
        setAnnualRate(rate);
    }

    // returns the loan amount
    public double getLoanAmount() {
        // precondition assertions
        assert loanAmount > 0: "Invalid loan amount: " + loanAmount;

        return loanAmount;
    }

    // returns the loan period in years
    public int getPeriod() {
        int period = numberOfPayments / MONTHS_IN_YEAR;

        // post condition assertions
        assert period % 12 != 0: "Invalid loan period: " + period;

        return period;
    }

    // returns the loan's annual interest rate
    public double getAnnualRate() {
        double annualRate = monthlyInterestRate * 100.0 * MONTHS_IN_YEAR;

        // post condition assertions
        assert annualRate > 0 && annualRate < 1000: "Invalid annual rate: " + annualRate;

        return annualRate;

    }

    // returns monthly payment
    public double getMonthlyPayment( ) {
        double monthlyPayment;
        monthlyPayment = (loanAmount * monthlyInterestRate)
                /
                (1 - Math.pow(1/(1 + monthlyInterestRate), numberOfPayments ));
        return monthlyPayment;
    }

    // returns total payment
    public double getTotalPayment( ) {
        double totalPayment;
        totalPayment = getMonthlyPayment( ) * numberOfPayments;
        return totalPayment;
    }

    // sets the loan amount
    public void setLoanAmount(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Loan amount cannot be negative. (" + amount + " was entered)");
        }
        if (amount == 0) {
            throw new IllegalArgumentException("Loan amount cannot be zero.");
        }
        if (amount == 100000000) {
            throw new IllegalArgumentException("Loan amount cannot exceed $100 million.");
        }
        loanAmount = amount;
    }

    // sets the loan period
    public void setPeriod(int periodInYears) throws IllegalArgumentException {
        if (periodInYears < 0) {
            throw new IllegalArgumentException("Loan period cannot be negative. (" + periodInYears + " was entered)");
        }
        if (periodInYears == 0) {
            throw new IllegalArgumentException("Loan period cannot be zero.");
        }
        if (periodInYears > 100) {
            throw new IllegalArgumentException("Loan period cannot exceed 100 years. (" + periodInYears + " was entered)");
        }
        numberOfPayments = periodInYears * MONTHS_IN_YEAR;

        // post condition assertions
        assert numberOfPayments % 12 == 0: "Invalid number of payments: " + numberOfPayments;
    }

    // sets the loan's annual interest rate
    public void setAnnualRate(double rate) throws IllegalArgumentException {
        if (rate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative. (" + rate + " was entered)");
        }
        if (rate > 1000) {
            throw new IllegalArgumentException("Interest rate cannot exceed 1000 percent. (" + rate + "was entered)");
        }
        monthlyInterestRate = rate / MONTHS_IN_YEAR / 100.0;

        // post condition assertions
        assert monthlyInterestRate >= 0 && monthlyInterestRate <= 1: "Invalid monthly interest rate value: " + monthlyInterestRate;
    }
}
