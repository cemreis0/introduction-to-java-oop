/*
Chapter 4 Sample Development: Loan Calculation
*/

import java.text.*;
import java.util.*;

public class Ch4LoanCalculator {
    // data members
    private Loan loan;

    // constructor
    public Ch4LoanCalculator() {

    }

    // main method
    public static void main(String[] args) {
        Ch4LoanCalculator calculator = new Ch4LoanCalculator();
        calculator.start();
    }

    // puts together the program
    public void start() {
        describeProgram();
        getInput();
        displayOutput();
    }

    // prints out the description of program
    private void describeProgram() {
        System.out.println("This program computes the monthly and total");
        System.out.println("payments for a given loan amount, annual ");
        System.out.println("interest rate, and loan period (# of years).");
        System.out.println();
    }

    // gets input from the user
    private void getInput() {
        double loanAmount, annualInterestRate;
        int loanPeriod;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Loan Amount ($): ");
        loanAmount = scanner.nextDouble();
        System.out.print("Annual Interest Rate (e.g., 9.5): ");
        annualInterestRate = scanner.nextDouble();
        System.out.print("Loan Period (years): ");
        loanPeriod = scanner.nextInt();

        loan = new Loan(loanAmount, loanPeriod, annualInterestRate);
    }

    // echo prints the input and displays the computed output
    private void displayOutput() {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Loan Amount             $" + loan.getLoanAmount());
        System.out.println("Annual Interest Rate:   " + df.format(loan.getAnnualRate()) + "%");
        System.out.println("Loan Period             " + loan.getPeriod() + " year(s)");
        System.out.println("Monthly payment is      $" + df.format(loan.getMonthlyPayment()));
        System.out.println("Total payment is        $" + df.format(loan.getTotalPayment()));
    }
}

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
        return loanAmount;
    }

    // returns the loan period in years
    public int getPeriod() {
        return numberOfPayments / MONTHS_IN_YEAR;
    }

    // returns the loan's annual interest rate
    public double getAnnualRate() {
        return monthlyInterestRate * 100.0 * MONTHS_IN_YEAR;
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
    public void setLoanAmount(double amount) {
        loanAmount = amount;
    }

    // sets the loan period
    public void setPeriod(int periodInYears) {
        numberOfPayments = periodInYears * MONTHS_IN_YEAR;
    }

    // sets the loan's annual interest rate
    public void setAnnualRate(double rate) {
        monthlyInterestRate = rate / MONTHS_IN_YEAR / 100.0;
    }
}