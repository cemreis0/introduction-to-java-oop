/**
 * Extend the MyJava Lo-Fat Burgers drive-through ordering system of
 * Exercise 24 on page 302 so the program can output sales figures. For each
 * item on the menu, the program keeps track of the sales. At closing time,
 * the program will output the sales figure in a format similar to the
 * following:
 *
 * Item        Sales Count   Total
 * Tofu Burger    25       $ 87.25
 * Cajun Chicken  30       $ 137.70
 * ...
 * Today's Total Sales: $ 2761.20
 */


package Ch10.Ch10DevEx;

import Ch5.Ch5DevEx.*;
import java.util.HashMap;
import java.util.Map;

public class MyJavaBurgerOutletWeeklyFigures {
    // data members
    private static Map<String, Integer> foodSalesMap = new HashMap<>();
    private static double totalSales = 0.0;

    public static void main(String[] args) {
        Order order;
        int orders = 0;

        while (orders < 5) {
            MyJavaBurgerOutlet.displayMenu();
            order = MyJavaBurgerOutlet.getOrder();
            MyJavaBurgerOutlet.displayOrderDetails(order);

            // Update food sales
            updateFoodSales(order.getEntreeName(), order.getEntreeCost());
            updateFoodSales(order.getSideDishName(), order.getSideDishCost());
            updateFoodSales(order.getDrinkName(), order.getDrinkCost());
            totalSales += order.getCost();

            orders++;
        }

        // Display the food sales and total sales at the end
        System.out.println("\nWeekly Food Sales:");
        for (Map.Entry<String, Integer> entry : foodSalesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.printf("\nTotal Weekly Sales: $ %.2f%n", totalSales);
    }

    // Method to update food sales in the map
    private static void updateFoodSales(String foodName, double cost) {
        if (foodSalesMap.containsKey(foodName)) {
            // If the food is already in the map, increment the sales
            int currentSales = foodSalesMap.get(foodName);
            foodSalesMap.put(foodName, currentSales + 1);
        } else {
            // If the food is not in the map, add it with sales count 1
            foodSalesMap.put(foodName, 1);
        }
    }
}
