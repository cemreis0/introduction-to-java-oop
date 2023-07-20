/*
 * Chapter 3 Level 2 Exercises
 * */

import java.text.*;
import java.util.*;

public class Ch3Lvl2 {
    public static void main(String[] args) {
        Ex17();
    }
    public static void Ex15() {
        /*  The velocity of a satellite circling around the Earth is computed by the
            formula
                v = (G*ME/r)^(1/2)
            where ME = 5.98 x 1024 kg is the mass of the Earth, r the distance from the
            center of the Earth to the satellite in meters, and G = 6.67 x 10^11 m3 / kg x s2
            the universal gravitational constant. The unit of the velocity v is m/s. Write a
            program that inputs the radius r and outputs the satellite’s velocity. Confirm
            that a satellite that is closer to the Earth travels faster. Define symbolic
            constants for ME and G. The distance to the Hubble Space Telescope from
            the center of the Earth, for example, is approximately 6.98 x 10^6 m.  */

        final double MASS_OF_EARTH = 5.98 * Math.pow(10, 24);
        final double GRAVITATIONAL_CONSTANT = 6.67 * Math.pow(10, -11);
        double velocity, distance;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0000");

        System.out.print("Enter the distance from the center of the Earth: ");
        distance = scanner.nextDouble();

        velocity = Math.sqrt(GRAVITATIONAL_CONSTANT * MASS_OF_EARTH / distance);

        System.out.print("The velocity of the satellite is " + df.format(velocity) + " m/s.");
    }
    public static void Ex16() {
        /*  Your weight is actually the amount of gravitational attraction exerted on
            you by the Earth. Since the Moon’s gravity is only one-sixth of the Earth’s
            gravity, on the Moon you would weigh only one-sixth of what you weigh on
            Earth. Write a program that inputs the user’s Earth weight and outputs her or
            his weight on Mercury, Venus, Jupiter, and Saturn. Use the values in this
            table.
                Planet      Multiply the Earth Weight by
                Mercury     0.4
                Venus       0.9
                Jupiter     2.5
                Saturn      1.1  */

        final double MERCURY_MULTIPLIER = 0.4;
        final double VENUS_MULTIPLIER = 0.9;
        final double JUPITER_MULTIPLIER = 2.5;
        final double SATURN_MULTIPLIER = 1.1;

        final String NEW_LINE = "\n";

        double weightOnTheEarth;

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Enter your weight on the Earth: ");
        weightOnTheEarth = scanner.nextDouble();

        System.out.print(   NEW_LINE +
                            "Weight on Mercury:     " + df.format(weightOnTheEarth*MERCURY_MULTIPLIER) + NEW_LINE +
                            "Weight on Venus:       " + df.format(weightOnTheEarth*VENUS_MULTIPLIER) + NEW_LINE +
                            "Weight on Jupiter:     " + df.format(weightOnTheEarth*JUPITER_MULTIPLIER) + NEW_LINE +
                            "Weight on Saturn:      " + df.format(weightOnTheEarth*SATURN_MULTIPLIER)
                        );
    }
    public static void Ex17() {
        /*  When you say you are 18 years old, you are really saying that the Earth has
            circled the Sun 18 times. Since other planets take fewer or more days than
            Earth to travel around the Sun, your age would be different on other planets.
            You can compute how old you are on other planets by the formula
                y = x * 365 / d
            where x is the age on Earth, y is the age on planet Y, and d is the number of
            Earth days the planet Y takes to travel around the Sun. Write an application
            that inputs the user’s Earth age and prints out his or her age on Mercury,
            Venus, Jupiter, and Saturn. The values for d are listed in the table.
                                    d = Approximate Number of Earth
                                    Days for This Planet to Travel
                Planet              around the Sun
                Mercury             88
                Venus               225
                Jupiter             4,380
                Saturn              10,767  */
        final int MERCURY = 88;
        final int VENUS = 225;
        final int JUPITER = 4380;
        final int SATURN = 10767;

        int ageOnEarth, ageOnMercury, ageOnVenus, ageOnJupiter, ageOnSaturn;

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0");

        System.out.print("Enter your age on the Earth: ");
        ageOnEarth = scanner.nextInt();

        ageOnMercury = ageOnEarth * 365 / MERCURY;
        ageOnVenus = ageOnEarth * 365 / VENUS;
        ageOnJupiter = ageOnEarth * 365 / JUPITER;
        ageOnSaturn = ageOnEarth * 365 / SATURN;

        System.out.print(
                "Age on Mercury: " + ageOnMercury + "\n" +
                "Age on Venus:   " + ageOnVenus + "\n" +
                "Age on Jupiter: " + ageOnJupiter + "\n" +
                "Age on Saturn:  " + ageOnSaturn
                        );
    }
    public static void Ex18() {
        /* Write a program to solve quadratic equations of the form
                Ax^2+Bx+C = 0
           where the coefficients A, B, and C are real numbers. The two real number
           solutions are derived by the formula
                x = (-B ∓ ((B^2 - 4*A*C)^(1/2))) / (2*A)  */

        double a, b, c, x1, x2;

        a = 1;
        b = -2;
        c = 1;

        x1 = (-b + Math.sqrt(b*b - 4*a*c) / (2*a));
        x2 = (-b - Math.sqrt(b*b - 4*a*c) / (2*a));

        System.out.print("Solution set of the equation " + a + "x^2+" + b + "x+" + c + " is {" + x1 + ", " + x2 + "}.");
    }
    public static void Ex19() {
        /*  Write a program that determines the number of days in a given semester.
            Input to the program is the year, month, and day information of the first and
            the last days of a semester. Hint: Create GregorianCalendar objects for the
            start and end dates of a semester and manipulate their DAY_OF_YEAR data.  */
        int startYear, startMonth, startDay, endYear, endMonth, endDay, daysInSemester;
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter the start date (yyyy mm dd): ");
        startYear = scanner.nextInt();
        startMonth = scanner.nextInt();
        startDay = scanner.nextInt();
        System.out.print("Enter the end date (yyyy mm dd): ");
        endYear = scanner.nextInt();
        endMonth = scanner.nextInt();
        endDay = scanner.nextInt();

        GregorianCalendar startDate = new GregorianCalendar(startYear, startMonth-1, startDay);
        GregorianCalendar endDate = new GregorianCalendar(endYear, endMonth-1, endDay);

        daysInSemester = endDate.get(Calendar.DAY_OF_YEAR) - startDate.get(Calendar.DAY_OF_YEAR);

        System.out.print(
                "Days in the semester " + sdf.format(startDate.getTime()) + "-" + sdf.format(endDate.getTime()) +
                        " is " + daysInSemester + " days."
        );
    }
    public static void Ex20() {
        /*  Modify the Ch3FindDayOfWeek program by accepting the date information
            as a single string instead of accepting the year, month, and day information
            separately. The input string must be in the MM/dd/yyyy format. For
            example, July 4, 1776, is entered as 07/04/1776. There will be exactly two
            digits for the month and day and four digits for the year.  */

        // already done in TheGregorianCalendarClass
    }
    public static void Ex21() {
        /*  Fibonacci sequence  */

        final double SQRT_OF_5 = Math.sqrt(5);
        double fibonacciNumber, occurrence;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the term: ");
        occurrence = scanner.nextDouble();

        fibonacciNumber = 1 / SQRT_OF_5 * (Math.pow(((1+SQRT_OF_5)/2), occurrence)-Math.pow(((1-SQRT_OF_5)/2), occurrence));

        System.out.print("The " + (int) occurrence + "th Fibonacci number is " + (int) fibonacciNumber);
    }
    public static void Ex22() {
        /*  Newton’s universal law of gravitation  */
        final double GRAVITATIONAL_CONSTANT = 6.67 * Math.pow(10, -8); // unit is dyn cm^2 / g^2

        double mass1, mass2, distance, force;

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Enter the mass of the first object (in g): ");
        mass1 = scanner.nextDouble();
        System.out.print("Enter the mass of the second object (in g): ");
        mass2 = scanner.nextDouble();
        System.out.print("Enter the distance between two objects (in cm): ");
        distance = scanner.nextDouble();

        force = GRAVITATIONAL_CONSTANT * (mass2 * mass2 / (distance*distance));

        System.out.print("The gravitational force between the objects is " + df.format(force) + " dyn.");
    }
    public static void Ex23() {
        /*  Dr. Caffeine’s Law of Program Readability states that the degree of program
            readability R (whose unit is mocha) is determined as
                R = k * (C * T^3 / V^3)
            where k is Ms. Latte’s constant, C is the number of lines in the program that
            contain comments, T is the time spent (in minutes) by the programmer
            developing the program, and V is the number of lines in the program that
            contain non-descriptive variable names. Write an application to compute the
            program readability R. Ms. Latte’s constant is 2.5E2 mocha lines^2/min^2.  */

        final double K = 250;

        double r, c, t, v;

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Enter the number of lines that contain comments: ");
        c = scanner.nextDouble();
        System.out.print("Enter the time spent: ");
        t = scanner.nextDouble();
        System.out.print("Enter the number of lines that contain non-descriptive variable names: ");
        v = scanner.nextDouble();

        r = K * c * t * t / (v*v*v);

        System.out.print("Readability: " + r);
    }
}
