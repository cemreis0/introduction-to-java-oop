/*
After starting a successful coffee beans outlet business, MyJava Coffee Outlet
is now venturing into the fast-food business. The first thing the management
decides is to eliminate the drive-through intercom. MyJava Lo-Fat Burgers is the
only fast-food establishment in town that provides a computer screen and mouse
for its drive-through customers. You are hired as a freelance computer consultant.
Write a program in Java that lists items for three menu categories: entree, side dish, and drink.
The following table lists the items available for each entry and their prices.
Choose appropriate methods for input and output.

Menu Items:
-------------------------------------------------------
|     Entree     |   Side Dish    |       Drink      |
-------------------------------------------------------
| Tofu Burger    | Rice Cracker   |    Cafe Mocha    |
| Price: $3.49   | Price: $0.79   | Price: $1.99     |
-------------------------------------------------------
| Cajun Chicken  | No-Salt Fries  |    Cafe Latte    |
| Price: $4.59   | Price: $0.69   | Price: $1.99     |
-------------------------------------------------------
| Buffalo Wings  | Zucchini       |     Espresso     |
| Price: $3.99   | Price: $1.09   | Price: $2.49     |
-------------------------------------------------------
| Rainbow Fillet | Brown Rice     |    Oolong Tea    |
| Price: $2.99   | Price: $0.59   | Price: $0.99     |
-------------------------------------------------------
*/


package Ch5.Ch5DevEx;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MyJavaBurgerOutlet {
    public static void main(String[] args) {
        Order order;

        displayMenu();
        order = getOrder();
        displayOrderDetails(order);
    }
    public static void displayMenu() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("| Item No. |     Entree     |   Side Dish    |       Drink      |");
        System.out.println("-------------------------------------------------------");
        System.out.println("|    1     | Tofu Burger    | Rice Cracker   |    Cafe Mocha    |");
        System.out.println("|          | Price: $3.49   | Price: $0.79   | Price: $1.99     |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|    2     | Cajun Chicken  | No-Salt Fries  |    Cafe Latte    |");
        System.out.println("|          | Price: $4.59   | Price: $0.69   | Price: $1.99     |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|    3     | Buffalo Wings  | Zucchini       |     Espresso     |");
        System.out.println("|          | Price: $3.99   | Price: $1.09   | Price: $2.49     |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|    4     | Rainbow Fillet | Brown Rice     |    Oolong Tea    |");
        System.out.println("|          | Price: $2.99   | Price: $0.59   | Price: $0.99     |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|    0     |   No Order     |   No Order     |     No Order     |");
        System.out.println("-----------------------------------------------------------------");

    }

    public static Order getOrder() {
        int entree, sideDish, drink; // menu items given by the user

        Order order;

        Scanner scanner = new Scanner(System.in);

        // get the order
        System.out.print("Entree: ");
        entree = scanner.nextInt();
        System.out.print("Side Dish: ");
        sideDish = scanner.nextInt();
        System.out.print("Drink: ");
        drink = scanner.nextInt();

        // create the Order instance
        order = new Order(entree, sideDish, drink);

        return order;
    }

    public static void displayOrderDetails(Order order) {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println(
            "Order Details" + "\n" +
            "       Entree: " + order.getEntreeName() + " - $" + order.getEntreeCost() + "\n" +
            "    Side Dish: " + order.getSideDishName() + " - $" + order.getSideDishCost() + "\n" +
            "        Drink: " + order.getDrinkName() + " - $" + order.getDrinkCost() + "\n" +
            "Total Cost: $" + df.format(order.getCost()) + "\n" +
            "Enjoy!"
        );
    }
}

class Order {
    // data members
    private int menu; // 1 - entree menu, 2 - side dish menu, 3 - drink menu
    private int entree, sideDish, drink; // 1 - first item in the menu, 2 - second etc.
    private double entreeCost, sideDishCost, drinkCost;
    private String entreeName, sideDishName, drinkName; // names for the items

    // constructor
    public Order(int givenEntree, int givenSideDish, int givenDrink) {
        entree = givenEntree; // 0 for no order from a menu
        sideDish = givenSideDish;
        drink = givenDrink;
        setNames();
        calculateCost();
    }

    public String getEntreeName() {
        return entreeName;
    }

    public String getSideDishName() {
        return sideDishName;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public double getEntreeCost() {
        return entreeCost;
    }

    public double getSideDishCost() {
        return sideDishCost;
    }

    public double getDrinkCost() {
        return drinkCost;
    }

    public double getCost() {
        double cost;
        cost = calculateCost();
        return cost;
    }

    private void setNames() {
        switch (entree) {
            case 0: entreeName = "No order";
                break;
            case 1: entreeName = "Tofu Burger";
                break;
            case 2: entreeName = "Cajun Chicken";
                break;
            case 3: entreeName = "Buffalo Wings";
                break;
            case 4: entreeName = "Rainbow Fillet";
                break;
            default: System.out.println("Invalid item selection.");
                break;
        }

        switch (sideDish) {
            case 0: sideDishName = "No order";
                break;
            case 1: sideDishName = "Rice Cracker";
                break;
            case 2: sideDishName = "No-Salt Fries";
                break;
            case 3: sideDishName = "Zucchini";
                break;
            case 4: sideDishName = "Brown Rice";
                break;
            default: System.out.println("Invalid item selection.");
                break;
        }

        switch (drink) {
            case 0: drinkName = "No order";
                break;
            case 1: drinkName = "Cafe Mocha";
                break;
            case 2: drinkName = "Cafe Latte";
                break;
            case 3: drinkName = "Espresso";
                break;
            case 4: drinkName = "Oolong Tea";
                break;
            default: System.out.println("Invalid item selection.");
                break;
        }
    }

    private double calculateCost() {
        double cost = 0;

        switch (entree) {
            case 0: entreeCost = 0.00; entreeName = "No order";
                break;
            case 1: entreeCost = 3.49; entreeName = "Tofu Burger";
                break;
            case 2: entreeCost = 4.59; entreeName = "Cajun Chicken";
                break;
            case 3: entreeCost = 3.99; entreeName = "Buffalo Wings";
                break;
            case 4: entreeCost = 2.99; entreeName = "Rainbow Fillet";
                break;
            default: System.out.println("Invalid item selection.");
                break;
        }

        switch (sideDish) {
            case 0: sideDishCost = 0.00; sideDishName = "No order";
                break;
            case 1: sideDishCost = 0.79; sideDishName = "Rice Cracker";
                break;
            case 2: sideDishCost = 4.59; sideDishName = "No-Salt Fries";
                break;
            case 3: sideDishCost = 3.99; sideDishName = "Zucchini";
                break;
            case 4: sideDishCost = 2.99; sideDishName = "Brown Rice";
                break;
            default: System.out.println("Invalid item selection.");
                break;
        }

        switch (drink) {
            case 0: drinkCost = 0.00; drinkName = "No order";
                break;
            case 1: drinkCost = 1.99; drinkName = "Cafe Mocha";
                break;
            case 2: drinkCost = 1.99; drinkName = "Cafe Latte";
                break;
            case 3: drinkCost = 2.49; drinkName = "Espresso";
                break;
            case 4: drinkCost = 0.99; drinkName = "Oolong Tea";
                break;
            default: System.out.println("Invalid item selection.");
                break;
        }

        cost = entreeCost + sideDishCost + drinkCost;

        return cost;
    }
}