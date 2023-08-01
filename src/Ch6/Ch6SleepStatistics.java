// Chapter 6 Sample Program: Sleep Statistics for Dorm Residents

package Ch6;

import java.util.*;
import java.text.*;

public class Ch6SleepStatistics {
    // data members
    private Scanner scanner;

    // main
    public static void main (String[] args) {
        Ch6SleepStatistics program = new Ch6SleepStatistics( );
        program.start();
    }

    // constructor
    public Ch6SleepStatistics() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        double sleepHour, sum = 0;
        int count = 0;
        String dorm;

        // enter the dorm name
        System.out.print("Dorm name: ");
        dorm = scanner.nextLine();

        //  loop: get hours of sleep for each resident
        //  until 0 is entered.
        sleepHour = getDouble("Enter sleep hours (0 - to stop:");
        while (sleepHour != 0) {
            sum += sleepHour;
            count++;

            sleepHour = getDouble("Enter sleep hours (0 - to stop): ");
        }

        if (count == 0) {
            System.out.println("No data entered.");
        }  else {
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(
                    "Average sleep time for " +
                            dorm + " is \n\n " +
                            df.format(sum/count) + " hours.");
        }
    }

    private double getDouble(String message) {
        double result;
        System.out.print(message);
        result = scanner.nextDouble();
        return result;
    }
}
