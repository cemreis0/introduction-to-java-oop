package Ch6.Ch6DevEx;

import java.util.Scanner;

class LoanCalculator {
    // data members
    Scanner scanner;
    private Loan loan;
    private double loanAmount, annualInterestRate;
    private int loanPeriod;

    // constructor
    public LoanCalculator() {

    }

    // main method
    public static void main(String[] args) {
        LoanCalculator calculator = new LoanCalculator();
        calculator.start();
    }

    // put together the program
    public void start() {
        describeProgram();
        getInput();
        createLoan();
        displayOutput();
    }

    // print out the description of program
    private void describeProgram() {
        System.out.println("This program computes the monthly");
        System.out.println("payments for a given loan amount, annual ");
        System.out.println("interest rate, and loan period (# years).");
        System.out.println();
    }

    // get input from the user
    private void getInput() {
        scanner = new Scanner(System.in);

        System.out.print("Loan Amount ($): ");
        loanAmount = scanner.nextDouble();
        System.out.print("Annual Interest Rate (e.g., 9.5): ");
        annualInterestRate = scanner.nextDouble();
        System.out.print("Loan Period (years): ");
        loanPeriod = scanner.nextInt();
    }

    // echo print the input and displays the computed output
    private void displayOutput() {
        int numberOfPayments = loan.getNumberOfPayments();

        // titles
        System.out.println();
        System.out.format("%-22s%-22s%-22s%-22s%-22s", "Payment No.", "Interest", "Principal", "Unpaid Balance", "Total Interest to Date");
        System.out.println();
        System.out.println();

        for (int i = 1; i <= numberOfPayments; i++) {
            System.out.format("%-25s%-25.2f%-25.2f%-25.2f%-25.2f",
                    i, loan.getMonthlyInterestPayment(i), loan.getMonthlyPrincipalPayment(i),
                    loan.getUnpaidBalance(), loan.getTotalInterestToDate(i));
            System.out.println();

            loan.updateUnpaidBalance(i);
        }
    }

    // create loan instance
    private void createLoan() {
        loan = new Loan(loanAmount, loanPeriod, annualInterestRate);
    }
}

public class Loan {
    // data members
    private static final int MONTHS_IN_YEAR = 12;
    private double loanAmount;
    private double unpaidBalance;
    private double monthlyInterestRate;
    private int numberOfPayments;

    public Loan(double amount, int period, double rate) {
        setLoanAmount(amount);
        setUnpaidBalance();
        setPeriod(period);
        setAnnualRate(rate);
    }

    // return the number of payments
    public int getNumberOfPayments() {
        return numberOfPayments;
    }

    // return the loan amount
    public double getLoanAmount() {
        return loanAmount;
    }

    // return the unpaid balance
    public double getUnpaidBalance() {
        return unpaidBalance;
    }

    // update the unpaid balance
    public void updateUnpaidBalance(int paymentNo) {
        unpaidBalance -= getMonthlyPrincipalPayment(paymentNo);
    }

    // return the loan period in years
    public int getPeriod() {
        return numberOfPayments / MONTHS_IN_YEAR;
    }

    // return the loan's annual interest rate
    public double getAnnualRate() {
        return monthlyInterestRate * 100.0 * MONTHS_IN_YEAR;
    }

    // return the total interest to date
    public double getTotalInterestToDate(int paymentNo) {
        double totalInterest = 0;
        double monthlyInterestPayment = 0;
        double remainingBalance = loanAmount;

        for (int i = 1; i <= paymentNo; i++) {
            for (int j = 1; j <= paymentNo; j++) {
                monthlyInterestPayment = remainingBalance * monthlyInterestRate;
            }

            double monthlyPrincipalPayment = getMonthlyPayment() - monthlyInterestPayment;

            totalInterest += monthlyInterestPayment;
            remainingBalance -= monthlyPrincipalPayment;
        }

        return totalInterest;
    }

    // return interest payment of a specific month
    public double getMonthlyInterestPayment(int paymentNo) {
        double monthlyInterestPayment = 0;
        for (int i = 1; i <= paymentNo; i++) {
            monthlyInterestPayment = unpaidBalance * monthlyInterestRate;
        }
        return monthlyInterestPayment;
    }

    // return principal payment of a specific month
    public double getMonthlyPrincipalPayment(int paymentNo) {
        double monthlyInterestPayment = getMonthlyInterestPayment(paymentNo);
        return getMonthlyPayment() - monthlyInterestPayment;
    }

    // return monthly payment
    public double getMonthlyPayment() {
        double monthlyPayment;
        monthlyPayment = (loanAmount * monthlyInterestRate)
                /
                (1 - Math.pow(1/(1 + monthlyInterestRate), numberOfPayments ));
        return monthlyPayment;
    }

    // return total payment
    public double getTotalPayment() {
        double totalPayment;
        totalPayment = getMonthlyPayment()  * numberOfPayments;
        return totalPayment;
    }

    // set the loan amount
    private void setLoanAmount(double givenLoanAmount) {
        loanAmount = givenLoanAmount;
    }

    // set unpaid balance equal to loan amount at first
    private void setUnpaidBalance() {
        unpaidBalance = loanAmount;
    }

    // set the loan period
    private void setPeriod(int givenPeriod) {
        numberOfPayments = givenPeriod * MONTHS_IN_YEAR;
    }

    // set the loan's annual interest rate
    private void setAnnualRate(double givenAnnualRate) {
        monthlyInterestRate = givenAnnualRate / MONTHS_IN_YEAR / 100.0;
    }
}
