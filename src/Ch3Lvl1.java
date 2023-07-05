/*
 * Chapter 3 Level 1 Exercises
 * */

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ch3Lvl1 {
    public static void main(String[] args) {
        Ex14();
    }
    public static void Ex7() {
        /*  Write a program to convert centimeters (input) to feet and inches (output).
            1 in = 2.54 cm  */

        final double IN_TO_CM = 2.54;
        double in, cm;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter inches: ");
        in = scanner.nextDouble();

        cm = in * IN_TO_CM;

        System.out.print(in + " inches is " + cm + " centimeters");
    }
    public static void Ex8() {
        /*  Write a program that inputs temperature in degrees Celsius and prints out the
            temperature in degrees Fahrenheit. The formula to convert degrees Celsius
            to equivalent degrees Fahrenheit is
            Fahrenheit = 1.8 x Celsius + 32  */

        double f, c;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Celsius degrees: ");
        c = scanner.nextDouble();

        f = 1.8 * c + 32;

        System.out.print(c + " Celsius degrees is " + f + " Fahrenheit");
    }
    public static void Ex9() {
        /*   Write a program that accepts a person’s weight and displays the number of
            calories the person needs in one day. A person needs 19 calories per pound
            of body weight, so the formula expressed in Java is
            calories = bodyWeight * 19;  */

        double calories, bodyWeight;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter body weight: ");
        bodyWeight = scanner.nextDouble();

        calories = bodyWeight * 19;

        System.out.print("You need " + calories + " calories a day.");
    }
    public static void Ex10() {
        /*   Write a program that does the reverse of Exercise 9, that is, input degrees
        Fahrenheit and prints out the temperature in degrees Celsius. The formula to
        convert degrees Fahrenheit to equivalent degrees Celsius is
        Celsius = 5 / 9 (Fahrenheit - 32)
          */

        double c, f;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter fahrenheit: ");
        f = scanner.nextDouble();

        c = (double) 5 / 9 * (f - 32);

        System.out.print(f + " Fahrenheit is " + c + " Celsius degrees.");
    }
    public static void Ex11() {
        /*  Write a program that inputs the year a person is born and outputs the age of
            the person in the following format:
            You were born in 1990 and will be (are) 18 this year.  */

        int birthYear, currentYear, age;
        Scanner scanner = new Scanner(System.in);
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        currentYear = Integer.parseInt(sdf.format(today));

        System.out.print("Enter the age you were born: ");
        birthYear = scanner.nextInt();

        age = currentYear - birthYear;

        System.out.print("You were born in " + birthYear + " and will be (are) " + age + " this year.");
    }
    public static void Ex12() {
        /*   A quantity known as the body mass index (BMI) is used to calculate the risk
            of weight-related health problems. BMI is computed by the formula
                BMI = w / ((h / 100.0) ^ 2)
            where w is weight in kilograms and h is height in centimeters. A BMI of
            about 20 to 25 is considered “normal.” Write an application that accepts
            weight and height (both integers) and outputs the BMI.  */

        int w, h;
        double bmi;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight as an integer: ");
        w = scanner.nextInt();
        System.out.print("Enter you height as an integer: ");
        h = scanner.nextInt();

        bmi = w / (Math.pow(((double) h / 100), 2));

        System.out.print("Your BMI is: " + bmi);
    }
    public static void Ex13() {
        /*  If you invest P dollars at R percent interest rate compounded annually, in
            N years, your investment will grow to
                P((1 + R / 100) ^ N)
            dollars. Write an application that accepts P, R, and N and computes the
            amount of money earned after N years  */

        double p, r, total;
        int n;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Enter amount: ");
        p = scanner.nextDouble();
        System.out.print("Enter interest rate: ");
        r = scanner.nextDouble();
        System.out.print("Enter years: ");
        n = scanner.nextInt();

        total = p * Math.pow((1 + r / 100), n);

        System.out.print("Your money will grow to " + df.format(total) + " dollars.");
    }
    public static void Ex14() {
        /*  The volume of a sphere is computed by the equation
                V = 4 / 3 * PI * (R ^ 2)
            where V is the volume and r is the radius of the sphere. Write a program that
            computes the volume of a sphere with a given radius r.  */

        final double PI = Math.PI;
        double v, r;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Enter the radius of the sphere: ");
        r = scanner.nextDouble();

        v = (double) 4 / 3 * PI * Math.pow(r, 3);

        System.out.print("The volume of the sphere with radius " + r + " is " + df.format(v) + ".");
    }
}
