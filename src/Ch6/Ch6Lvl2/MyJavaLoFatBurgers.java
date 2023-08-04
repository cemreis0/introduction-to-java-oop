/*
Extend the program in Exercise 15 so that customers can order more than
one item from each menu category. For example, the customer can buy two
orders of Tofu Burgers and three orders of Buffalo Wings from the Entree
menu category.
*/

package Ch6.Ch6Lvl2;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MyJavaLoFatBurgers {
    public static void main(String[] args) {
        double total = getOrder();

        System.out.print("Total: $" + total);
    }
    public static void displayEntreeMenu() {
        System.out.println();
        System.out.println("| Item No. |     Entree      |   Price   |");
        System.out.println("------------------------------------------");
        System.out.println("|    1     | Tofu Burger     | $3.49     |");
        System.out.println("|    2     | Cajun Chicken   | $4.59     |");
        System.out.println("|    3     | Buffalo Wings   | $3.99     |");
        System.out.println("|    4     | Rainbow Fillet  | $2.99     |");
        System.out.println();
    }

    public static void displaySideDishMenu() {
        System.out.println();
        System.out.println("| Item No. |   Side Dish   |   Price   |");
        System.out.println("----------------------------------------");
        System.out.println("|    1     | Rice Cracker  | $0.79     |");
        System.out.println("|    2     | No-Salt Fries | $0.69     |");
        System.out.println("|    3     | Zucchini      | $1.09     |");
        System.out.println("|    4     | Brown Rice    | $0.59     |");
        System.out.println();
    }

    public static void displayDrinkMenu() {
        System.out.println();
        System.out.println("| Item No. |    Drink      |   Price   |");
        System.out.println("----------------------------------------");
        System.out.println("|    1     | Cafe Mocha    | $1.99     |");
        System.out.println("|    2     | Cafe Latte    | $1.99     |");
        System.out.println("|    3     | Espresso      | $2.49     |");
        System.out.println("|    4     | Oolong Tea    | $0.99     |");
        System.out.println();
    }

    public static double getOrder() {
        int entree, sideDish, drink; // menu items given by the user
        int entreeQuantity, sideDishQuantity, drinkQuantity; // number of items ordered
        double total = 0; // total cost

        Order order = new Order();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to MyJava Lo-Fat Burger!");

        // get entree order
        displayEntreeMenu();
        while (true) {
            System.out.println("Type 0 to finish ordering entree.");
            System.out.println();

            System.out.print("Entree: ");
            entree = scanner.nextInt();

            if (entree < 0 || entree > 4) {
                System.out.println("Invalid item selection.");
                break;
            }

            if (entree == 0) {
                break;
            }

            System.out.print("Quantity: ");
            entreeQuantity = scanner.nextInt();

            if (entreeQuantity <= 0) {
                System.out.println("Invalid quantity entered.");
                break;
            }

            total += order.getEntreeCost(entree, entreeQuantity);
        }

        // get side dish order
        while (true) {
            displaySideDishMenu();

            System.out.println("Type 0 to finish ordering side dish.");
            System.out.println();

            System.out.print("Side Dish: ");
            sideDish = scanner.nextInt();

            if (sideDish < 0 || sideDish > 4) {
                System.out.println("Invalid item selection.");
                break;
            }

            if (sideDish == 0) {
                break;
            }

            System.out.print("Quantity: ");
            sideDishQuantity = scanner.nextInt();

            if (sideDishQuantity <= 0) {
                System.out.println("Invalid quantity entered.");
                break;
            }

            total += order.getEntreeCost(sideDish, sideDishQuantity);
        }

        // get drink order
        while (true) {
            displayDrinkMenu();

            System.out.println("Type 0 to finish ordering drink.");
            System.out.println();

            System.out.print("Drink: ");
            drink = scanner.nextInt();

            if (drink < 0 || drink > 4) {
                System.out.println("Invalid item selection.");
                break;
            }

            if (drink == 0) {
                break;
            }

            System.out.print("Quantity: ");
            drinkQuantity = scanner.nextInt();

            if( drinkQuantity <= 0) {
                System.out.println("Invalid quantity entered.");
                break;
            }

            total += order.getEntreeCost(drink, drinkQuantity);
        }

        return total;
    }
}

class Order {
    // data members

    // constructor
    public Order() {

    }

    public double getEntreeCost(int entree, int quantity) {
        double cost;

        switch (entree) {
            case 1: cost = 0.79;
                break;
            case 2: cost = 0.69;
                break;
            case 3: cost = 3.99;
                break;
            case 4: cost = 2.99;
                break;

            case 0:
            default: cost = 0.00;
                break;
        }

        cost = entree * quantity;
        return cost;
    }

    public double getSideDishCost(int sideDish, int quantity) {
        double cost;

        switch (sideDish) {
            case 1: cost = 3.49;
                break;
            case 2: cost = 4.59;
                break;
            case 3: cost = 3.99;
                break;
            case 4: cost = 2.99;
                break;

            case 0:
            default: cost = 0.00;
                break;
        }

        cost = sideDish * quantity;
        return cost;
    }

    public double getDrinkCost(int drink, int quantity) {
        double cost;

        switch (drink) {
            case 0: cost = 0.00;
                break;
            case 1:;
            case 2: cost = 1.99;
                break;
            case 3: cost = 2.49;
                break;
            case 4: cost = 0.99;
                break;
            default: System.out.println("Invalid item selection.");
                break;
        }

        cost = drink * quantity;
        return cost;
    }
}