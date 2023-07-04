import java.util.*;
import java.text.*;

public class Ch3LoanCalculator {
    public static void main(String[] args) {
        LoanCalculator();
    }
    public static void LoanCalculator() {
        /*  Chapter 3 Sample Development: Loan Calculator. Problem Statement:
            Write a loan calculator program that computes both monthly and total
            payments for a given loan amount, annual interest rate, and loan period
        */

        /*
            L: Loan Amount
            R: Monthly interest rate
            N: Number of payments
            Monthly Payment:
            (LxR)/(1-(1/(1+R))^N)
        */

        final String NEW_LINE = "\n";
        final int MONTHS_IN_YEAR = 12;

        double loanAmount, annualInterestRate;
        double monthlyPayment, totalPayment;
        double monthlyInterestRate;
        int loanPeriod;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        //describe the program
        System.out.println("This program computes the monthly and total");
        System.out.println("payments for a given loan amount, annual ");
        System.out.println("interest rate, and loan period.");
        System.out.println("Loan amount in dollars and cents,  e.g., 12345.50");
        System.out.println("Annual interest rate in percentage, e.g., 12.75");
        System.out.println("Loan period in number of years, e.g., 15");
        System.out.println("\n"); //skip two lines

        // get input values
        System.out.print("Loan Amount ($): ");
        loanAmount = scanner.nextDouble();
        System.out.print("Annual Interest Rate (e.g. 9.5): ");
        annualInterestRate = scanner.nextDouble();
        System.out.print("Loan Period (years): ");
        loanPeriod = scanner.nextInt();

        // compute the monthly and total payments
        monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / 100;
        numberOfPayments = loanPeriod * MONTHS_IN_YEAR;
        monthlyPayment = (loanAmount * monthlyInterestRate) /
                         (1 - Math.pow(1 / (1 + monthlyInterestRate), numberOfPayments));
        totalPayment = monthlyPayment * numberOfPayments;

        // echo print the input values
        System.out.println(NEW_LINE +
                           "Loan amount             $" + loanAmount + NEW_LINE +
                           "Annual interest rate     " + annualInterestRate + NEW_LINE +
                           "Loan period (years)      " + loanPeriod +
                           NEW_LINE + NEW_LINE +
                           "Monthly payment         $" + df.format(monthlyPayment) + NEW_LINE +
                           "Total payment           $" + df.format(totalPayment));
    }
}
