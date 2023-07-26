/*
Chapter 5 Level 1 Exercises
*/

package Ch5;

import java.util.Scanner;

public class Ch5Lvl1 {
    public static void main(String[] args) {
        Ex10();
    }
    public static void Ex9() {
        /*
        One million is 10^6 and 1 billion is 10^9.
        Write a program that reads a power
        of 10 (6, 9, 12, etc.) and displays how big the number is (Million, Billion,
        etc.). Display an appropriate message for the input value that has no
        corresponding word. The table below shows the correspondence between
        the power of 10 and the word for that number.
        Power of 10     Number
        6               Million
        9               Billion
        12              Trillion
        15              Quadrillion
        18              Quintillion
        21              Sextillion
        30              Nonillion
        100             Googol
        */

        Scanner scanner = new Scanner(System.in);
        int power;
        String number;

        System.out.println("Enter power of 10: ");
        power = scanner.nextInt();

        switch (power) {
            case 6: number = "million";
            break;
            case 9: number = "billion";
            break;
            case 12: number = "trillion";
            break;
            case 15: number = "quadrillion";
            break;
            case 18: number = "quintillion";
            break;
            case 21: number = "sextillion";
            break;
            case 30: number = "nonillion";
            break;
            case 100: number = "googol";
            break;
            default: number = "no corresponding number";
            break;
        }

        System.out.println("The number that is 10 to the power of " + power + " is " + number + ".");
    }

    public static void Ex10() {
        /*
         Write a program RecommendedWeightWithTest by extending the
        RecommendedWeight (see Exercise 8 on page 209). The extended program
        will include the following test:
            if (the height is between 140cm and 230cm)
                compute the recommended weight
            else
                display an error message
        */
        double rw, height, age, weight;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter height: ");
        height = scanner.nextDouble();
        System.out.print("Enter age: ");
        age = scanner.nextDouble();

        if (height > 140 && height < 230) {
            rw = (height - 100 + age / 10) * 0.90;
        } else {
            rw = -1; // error
        }

        if (rw != -1.0) {
            System.out.println("Your recommended weight is " + rw);
            System.out.println("Enter your current weight");
            weight = scanner.nextDouble();
            if (weight > rw + 10) {
                System.out.println("You should exercise more");
            } else if (weight < rw - 20){
                System.out.println("You need more nourishment");
            }
        } else {
            System.out.println("Height must be between 140 and 230 cm");
        }
    }
}
