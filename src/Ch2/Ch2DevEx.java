/*
* Chapter 2 Development Exercises
* */

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ch2DevEx {
    public static void main(String[] args) {
        Ex35();
    }
    public static void Ex34() {
        /*
        * Program that asks a user his/her birthdate and
        * replies with the day of the week they were born
        * */
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String bdateString;

        System.out.print("Enter your birthdate (year-month-day): ");
        // Get the user's birthdate as a string
        bdateString = scanner.nextLine();

        // Convert the string into a java.util.Date object
        java.util.Date bdate = java.sql.Date.valueOf(bdateString);

        // Format the converted Date object through SimpleDateFormat and print it out
        System.out.println(sdf.format(bdate));
    }
    public static void Ex35() {
        /*
         * Program that asks a user their full name in the format <first middle last>
         * and replies with the name in the format <last, first middle-initial>
         * */
        Scanner scanner = new Scanner(System.in);
        String name, first, middle, last;

        System.out.print("Enter your full name (first middle last): ");
        // Get the user's birthdate as a string
        name = scanner.nextLine();

        // Strip the name to first, middle and last
        first = name.substring(0, name.indexOf(" "));
        name = name.substring(name.indexOf(" ")+1);
        middle = name.substring(0, name.indexOf(" ")); // Starting at 1 as the blank space is included in the new name
        last = name.substring(name.indexOf(" ") + 1);

        // Print out the name in the new format
        System.out.println(last + ", " + first + " " + middle.charAt(0) + ".");
    }
}
