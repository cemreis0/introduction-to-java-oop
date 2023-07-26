/*
Chapter 5 Level 2 Exercises
*/

package Ch5;

import java.util.Scanner;

public class Ch5Lvl2 {
    public static void main(String[] args) {
        Ex13();
    }

    public static void Ex12() {
        /*
         Write a program that replies either Leap Year or Not a Leap Year, given a
        year. It is a leap year if the year is divisible by 4 but not by 100 (for
        example, 1796 is a leap year because it is divisible by 4 but not by 100). A
        year that is divisible by both 4 and 100 is a leap year if it is also divisible by
        400 (for example, 2000 is a leap year, but 1800 is not).
        */
        int year;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter year: ");
        year = scanner.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

    public static void Ex13() {
        /*
        Employees at MyJava Lo-Fat Burgers earn the basic hourly wage of $7.25.
        They will receive time-and-a-half of their basic rate for overtime hours.
        In addition, they will receive a commission on the sales they generate
        while tending the counter. The commission is based on the following
        formula:

            $1.00 to $99.99         5% of total sales
            $100.00 to $299.99      10% of total sales
            >=$300.00                 15% of total sales

        Write a program that inputs the number of hours worked and the total sales
        and computes the wage.
         */
        int hoursWorked;
        double totalSales, monthlyWage;

        Wage wage = new Wage();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter hours worked this month: ");
        hoursWorked = scanner.nextInt();
        System.out.print("Enter total sales this month: $");
        totalSales = scanner.nextDouble();

        wage.setHoursWorked(hoursWorked);
        wage.setTotalSales(totalSales);

        monthlyWage = wage.getWage();

        System.out.println("Wage this month: " + monthlyWage);
    }
}


class Wage {
    // data members
    public static final double HOURLY_WAGE = 7.25;
    public static final double HOURLY_OVERTIME_WAGE = HOURLY_WAGE * 1.5;
    public static final double REGULAR_WORK_HOURS = 160;
    private int hoursWorked; // monthly
    private double totalSales; // monthly
    private double wage; // monthly

    // constructor
    public Wage() {
        wage = 0;
        hoursWorked = 0;
        totalSales = 0;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setHoursWorked(int givenHoursWorked) {
        hoursWorked = givenHoursWorked;
    }

    public void setTotalSales(double givenTotalSales) {
        totalSales = givenTotalSales;
    }

    public double getWage() {
        calculateWage();
        return wage;
    }

    private void calculateWage() {
        if (hoursWorked >= 160) {
            wage = HOURLY_WAGE * 160 + HOURLY_OVERTIME_WAGE * (hoursWorked - 160);
        } else {
            wage = hoursWorked * HOURLY_WAGE;
        }
        if (totalSales >= 1.00 && totalSales <= 99.99) {
            wage += totalSales * 0.05;
        } else if (totalSales >= 100.00 && totalSales <= 299.99) {
            wage += totalSales * 0.1;
        } else if (totalSales >= 300.00) {
            wage += totalSales * 0.15;
        }
    }
}