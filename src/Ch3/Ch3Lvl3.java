/*
 * Chapter 3 Level 3 Exercises
 * */

import java.text.*;
import java.util.*;

public class Ch3Lvl3 {
    public static void main(String[] args) {
        Ex26();
    }
    public static void Ex24() {
        /*  Write a program that accepts the unit weight of a bag of coffee in pounds and
            the number of bags sold and displays the total price of the sale.  */

        final double PRICE = 5.99;
        final double TAX = 0.0725;
        final String NEW_LINE = "\n";
        double unitWeight, numberOfUnits, totalPrice, totalPriceWithTax;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the unit weight (lb): ");
        unitWeight = scanner.nextDouble();
        System.out.print("Enter the number of bags: ");
        numberOfUnits = scanner.nextDouble();

        totalPrice = unitWeight * numberOfUnits * PRICE;
        totalPriceWithTax = totalPrice + totalPrice * TAX;

        System.out.print(
                "Number of bags sold:  " + numberOfUnits + NEW_LINE +
                "     Weight per bag:  " + unitWeight + " lb" + NEW_LINE +
                "    Price per pound:  " + PRICE + NEW_LINE +
                "          Sales tax:  " + "7.25%" + NEW_LINE + NEW_LINE +
                "        Total price:  " + totalPriceWithTax
        );
    }
    public static void Ex25() {
        /*  Population growth prediction
                y = ce^(kx)  */

        int population1, year1, population2, year2, yearForPrediction;
        double populationPrediction;
        double k; // k is like a growth factor
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a census year: ");
        year1 = scanner.nextInt();
        System.out.print("Enter the population in " + year1 + ": ");
        population1 = scanner.nextInt();
        System.out.print("Enter another census year: ");
        year2 = scanner.nextInt();
        System.out.print("Enter the population in " + year2 + ": ");
        population2 = scanner.nextInt();

        // compute k
        k = 1 / ((double) year2 - year1) * Math.log((double) population2/population1);

        System.out.print("Enter the year for the population prediction: ");
        yearForPrediction = scanner.nextInt();

        // calculate the predicted population
        populationPrediction = population1 * Math.pow(Math.E, (k*(yearForPrediction-year1)));

        System.out.print("Population prediction for " + yearForPrediction + " is " + (int) populationPrediction + ".");
    }
    public static void Ex26() {
        /*  Effective Annual Interest Rate
                MR = (1 x EAR)^(1/12) - 1
            MR = monthly rate, EAR = effective annual rate  */

        final String NEW_LINE = "\n";
        final int MONTHS_IN_YEAR = 12;

        double loanAmount, annualInterestRate, effectiveAnnualInterestRate;
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
        effectiveAnnualInterestRate = Math.pow(1+annualInterestRate/100/12, 12) - 1; // dividing annualInterestRate to get the decimal
        monthlyInterestRate = (Math.pow((1 + effectiveAnnualInterestRate), (double) 1 / MONTHS_IN_YEAR) - 1);
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
    public static void Ex27() {
        /*  Ask the user to enter his or her birthday in the MM/DD/YYYY format and
            output the number of days between the birthday and today. This gives the
            person’s age in days.  */

        int month, day, year;
        long days;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your birthdate (MM DD YY): ");
        month = scanner.nextInt();
        day = scanner.nextInt();
        year = scanner.nextInt();

        GregorianCalendar birthDate = new GregorianCalendar(year, month-1, day);
        GregorianCalendar today = new GregorianCalendar();
        today.getTime();
        days = (today.getTimeInMillis() - birthDate.getTimeInMillis()) / 86400000; // milliseconds to days formula;

        System.out.print("You are " + days + " days old!");
    }

}