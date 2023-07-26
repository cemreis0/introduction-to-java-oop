/*
 * Chapter 5 Development Exercise 21
 *
 *  Ms. Latte’s Mopeds ‘R Us Rental Application
 *
 * This program computes the rental charge for mopeds rented at Monterey Beach Boardwalk.
 * The rental charges vary based on the type of moped, the rental day (weekday or weekend),
 * and the number of hours rented.
 *
 * Rental Charges:
 * Moped Type  | Weekday Rental                  | Weekend Rental
 * --------------------------------------------------------------------
 * 50cc Mopette| $15.00 for the first 3 hours    | $30.00 for the first 3 hours
 *             | $2.50 per hour after the first 3 hours | $7.50 per hour after the first 3 hours
 *
 * 250cc Mohawk| $25.00 for the first 3 hours    | $35.00 for the first 3 hours
 *             | $3.50 per hour after the first 3 hours | $8.50 per hour after the first 3 hours
 *
 * User Inputs:
 * 1. Type of moped (50cc Mopette or 250cc Mohawk)
 * 2. Rental day (Weekday or Weekend)
 * 3. Number of hours rented
 *
 * The program will calculate and display the rental charge based on the provided inputs.
 */


package Ch5;

import java.util.Scanner;

public class LatteMopeds {
    public static void main(String[] args) {
        String mopedType;
        boolean weekend;
        int numberOfHours;

        Rent rent;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter moped type (moped for 50cc Mopette, mohawk for 250cc Mohawk): ");
        mopedType = scanner.nextLine();
        System.out.print("Are you renting on a weekend?: (true for yes, false for no): ");
        weekend = scanner.nextBoolean();
        System.out.print("Enter the number of hours you want to rent: ");
        numberOfHours = scanner.nextInt();

        rent = new Rent(mopedType, weekend);
        rent.setNumberOfHours(numberOfHours);

        System.out.println(
                "             Moped type: " + rent.getMopedType() + "\n" +
                "               Weekend?: " + rent.isWeekend() + "\n" +
                " Number of hours rented: " + rent.getNumberOfHours() + "\n" +
                "          Total charge: $" + rent.getCharge()
                );
    }
}

class Rent {
    // data members
    private static final double MOPETTE_CHARGE_FIRST_3_HOURS_WEEKDAY = 15.00,
            MOPETTE_CHARGE_AFTER_3_HOURS_WEEKDAY = 2.50, // every hour
            MOPETTE_CHARGE_FIRST_3_HOURS_WEEKEND = 30.00,
            MOPETTE_CHARGE_AFTER_3_HOURS_WEEKEND = 7.50, // every hour
            MOHAWK_CHARGE_FIRST_3_HOURS_WEEKDAY = 25.00,
            MOHAWK_CHARGE_AFTER_3_HOURS_WEEKDAY = 3.50, // every hour
            MOHAWK_CHARGE_FIRST_3_HOURS_WEEKEND = 35.00,
            MOHAWK_CHARGE_AFTER_3_HOURS_WEEKEND = 8.50; // every hour

    private String mopedType; // 50cc Mopette, 250cc Mohawk
    private boolean weekend;
    private int numberOfHours; // number of hours rented

    // constructor
    public Rent(String givenMopedType, boolean givenWeekend) {
        mopedType = givenMopedType;
        weekend = givenWeekend;
        numberOfHours = 0;
    }

    public double getCharge() {
        double charge;
        if (mopedType.equals("moped")) {
            charge = calculateMopetteCharge();
        } else if (mopedType.equals("mohawk")) {
            charge = calculateMohawkCharge();
        } else {
            charge = -1;
        }

        if (charge == -1) {
            System.out.println("An error occurred.");
        }

        return charge;
    }

    public double getNumberOfHours() {
        return numberOfHours;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public String getMopedType() {
        return mopedType;
    }

    public void setNumberOfHours(int givenNumberOfHours) {
        numberOfHours = givenNumberOfHours;
    }

    public void setWeekend(boolean givenWeekend) {
        weekend = weekend;
    }

    public void setMopedType(String givenMopedType) {
        mopedType = givenMopedType;
    }

    private double calculateMopetteCharge() {
        double charge = -1;
        if (isWeekend()) {
            if (numberOfHours > 3) {
                charge = MOPETTE_CHARGE_FIRST_3_HOURS_WEEKEND + MOPETTE_CHARGE_AFTER_3_HOURS_WEEKEND * (numberOfHours - 3);
            } else if (numberOfHours <= 3 && numberOfHours > 0) {
                charge = MOPETTE_CHARGE_FIRST_3_HOURS_WEEKEND;
            } else {
                System.out.println("Number entered is not valid.");
            }
        } else {
            if (numberOfHours > 3) {
                charge = MOPETTE_CHARGE_FIRST_3_HOURS_WEEKDAY + MOPETTE_CHARGE_AFTER_3_HOURS_WEEKDAY * (numberOfHours - 3);
            } else if (numberOfHours <= 3 && numberOfHours > 0) {
                charge = MOPETTE_CHARGE_FIRST_3_HOURS_WEEKDAY;
            } else {
                System.out.println("Number entered is not valid.");
            }
        }
        return charge;
    }

    private double calculateMohawkCharge() {
        double charge = -1;
        if (isWeekend()) {
            if (numberOfHours > 3) {
                charge = MOHAWK_CHARGE_FIRST_3_HOURS_WEEKEND + MOHAWK_CHARGE_AFTER_3_HOURS_WEEKEND * (numberOfHours - 3);
            } else if (numberOfHours <= 3 && numberOfHours > 0) {
                charge = MOHAWK_CHARGE_FIRST_3_HOURS_WEEKEND;
            } else {
                System.out.println("Number entered is not valid.");
            }
        } else {
            if (numberOfHours > 3) {
                charge = MOHAWK_CHARGE_FIRST_3_HOURS_WEEKDAY + MOHAWK_CHARGE_AFTER_3_HOURS_WEEKDAY * (numberOfHours - 3);
            } else if (numberOfHours <= 3 && numberOfHours > 0) {
                charge = MOHAWK_CHARGE_FIRST_3_HOURS_WEEKDAY;
            } else {
                System.out.println("Number entered is not valid.");
            }
        }
        return charge;
    }
}