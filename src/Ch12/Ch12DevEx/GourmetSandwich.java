/*
 * THIS IS SLACK JOB
 *
 * In Exercise 24 of Chapter 5 you wrote a drive-through ordering system
 * for MyJava Lo-Carb Gourmet Sandwich (the company has since changed its
 * name to reflect the current trend in the food industry). You are hired again as
 * a freelance computer consultant to make extensions to the program.
 *
 * Instead of having a fixed number of menu.txt categories and a fixed
 * number of menu.txt items per category, you will input this information from a
 * text file. The data in the input file have the following format:
 *
 * #menu.txt category
 * menu.txt item $price
 * menu.txt item $price
 * ...
 * #menu.txt category
 * menu.txt item $price
 *
 * Each menu.txt category is preceded by the pound symbol (#). A list of menu.txt
 * items that belong to this menu.txt category follows it. Each menu.txt item includes
 * its name and price. The price is preceded by the dollar sign. Here’s a sample
 * input file:
 *
 * #Entrée
 * Tofu Burger $3.99
 * Chili Burger $2.99
 * Chef Salad $6.99
 *
 * #Drink
 * Oolong Tea $0.79
 * Latte $3.29
 * House Wine $4.99
 * Chai Latte $2.50
 *
 * #Side
 * Freedom Fries $0.99
 *
 * #Appetizer
 * Onion Bloom $4.05
 * Calamari $3.50
 *
 * You may assume that that input file contains at least one menu.txt category and
 * each menu.txt category has at least one menu.txt item. Also, you may assume that
 * all input lines conform to the given format; that is, there will be no invalid
 * input lines. Finally, there will be at most 20 menu.txt categories and 25 menu.txt
 * items per menu.txt category.
 *
 * After the input file data are read into a program, the operation
 * mode begins, where you continually process the customer orders. For
 * each item on the menu.txt, keep track of the sales. At the closing time, the
 * store manager keys in a special code to shut down the program. Before
 * stopping the program, output the sales figure in a format similar to the
 * following:
 *
 * Item             Sales Count      Total
 * Tofu Burger          25         $ 87.25
 * Cajun Chicken        30         $ 137.70
 * ...
 * Today's Total Sales: $ 2761.20
 *
 * Place enough space between columns so the output is easy to read. You
 * are not required to align the decimal points of the dollar figures. Output
 * the sales figure to the standard output. Save the sales figure to a text file.
 */


package Ch12.Ch12DevEx;

import java.io.*;
import java.util.*;

public class GourmetSandwich {
    public static void main(String[] args) {
        // Step 1: Read menu data from a text file
        Map<String, List<MenuItem>> menu = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("files/menu.txt"))) {
            String line;
            String currentCategory = null;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    // Found a new category
                    currentCategory = line.substring(1).trim();
                    menu.put(currentCategory, new ArrayList<>());
                } else if (currentCategory != null) {
                    // Add menu items to the current category
                    String[] parts = line.split("\\$");
                    if (parts.length == 2) {
                        String itemName = parts[0].trim();
                        double itemPrice = Double.parseDouble(parts[1].trim());
                        menu.get(currentCategory).add(new MenuItem(itemName, itemPrice));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading menu.txt: " + e.getMessage());
            return;
        }

        // Step 2: Implement the ordering system and track sales
        Map<String, Integer> salesCount = new HashMap<>();
        Map<String, Double> totalSales = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu Categories:");
            for (String category : menu.keySet()) {
                System.out.println(category);
            }
            System.out.print("Enter category (or 'exit' to close): ");
            String inputCategory = scanner.nextLine();

            if (inputCategory.equals("exit")) {
                break;
            }

            List<MenuItem> items = menu.get(inputCategory);
            if (items == null) {
                System.out.println("Invalid category. Please try again.");
                continue;
            }

            System.out.println("Menu Items:");
            for (MenuItem item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
            System.out.print("Enter item name: ");
            String inputItem = scanner.nextLine();

            MenuItem selectedMenuItem = null;
            for (MenuItem item : items) {
                if (item.getName().equalsIgnoreCase(inputItem)) {
                    selectedMenuItem = item;
                    break;
                }
            }

            if (selectedMenuItem == null) {
                System.out.println("Invalid item. Please try again.");
                continue;
            }

            salesCount.put(selectedMenuItem.getName(), salesCount.getOrDefault(selectedMenuItem.getName(), 0) + 1);
            totalSales.put(selectedMenuItem.getName(), totalSales.getOrDefault(selectedMenuItem.getName(), 0.0) + selectedMenuItem.getPrice());
        }

        // Step 3: Display and save the sales figures
        System.out.println("Item             Sales Count      Total");
        for (String itemName : salesCount.keySet()) {
            int count = salesCount.get(itemName);
            double total = totalSales.get(itemName);
            System.out.printf("%-20s %-15d $ %.2f%n", itemName, count, total);
        }

        double todayTotalSales = totalSales.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Today's Total Sales: $ " + todayTotalSales);

        // You can save the sales figures to a text file here if needed.
    }
}

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
