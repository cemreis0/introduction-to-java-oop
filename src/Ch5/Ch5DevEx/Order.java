package Ch5.Ch5DevEx;

public class Order {
    // data members
    private int entree, sideDish, drink; // 1 - first item in the menu.txt, 2 - second etc.
    private double entreeCost, sideDishCost, drinkCost;
    private String entreeName, sideDishName, drinkName; // names for the items

    // constructor
    public Order(int givenEntree, int givenSideDish, int givenDrink) {
        entree = givenEntree; // 0 for no order from a menu.txt
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
            case 0:
                entreeName = "No order";
                break;
            case 1:
                entreeName = "Tofu Burger";
                break;
            case 2:
                entreeName = "Cajun Chicken";
                break;
            case 3:
                entreeName = "Buffalo Wings";
                break;
            case 4:
                entreeName = "Rainbow Fillet";
                break;
            default:
                System.out.println("Invalid item selection.");
                break;
        }

        switch (sideDish) {
            case 0:
                sideDishName = "No order";
                break;
            case 1:
                sideDishName = "Rice Cracker";
                break;
            case 2:
                sideDishName = "No-Salt Fries";
                break;
            case 3:
                sideDishName = "Zucchini";
                break;
            case 4:
                sideDishName = "Brown Rice";
                break;
            default:
                System.out.println("Invalid item selection.");
                break;
        }

        switch (drink) {
            case 0:
                drinkName = "No order";
                break;
            case 1:
                drinkName = "Cafe Mocha";
                break;
            case 2:
                drinkName = "Cafe Latte";
                break;
            case 3:
                drinkName = "Espresso";
                break;
            case 4:
                drinkName = "Oolong Tea";
                break;
            default:
                System.out.println("Invalid item selection.");
                break;
        }
    }

    private double calculateCost() {
        double cost = 0;

        switch (entree) {
            case 0:
                entreeCost = 0.00;
                entreeName = "No order";
                break;
            case 1:
                entreeCost = 3.49;
                entreeName = "Tofu Burger";
                break;
            case 2:
                entreeCost = 4.59;
                entreeName = "Cajun Chicken";
                break;
            case 3:
                entreeCost = 3.99;
                entreeName = "Buffalo Wings";
                break;
            case 4:
                entreeCost = 2.99;
                entreeName = "Rainbow Fillet";
                break;
            default:
                System.out.println("Invalid item selection.");
                break;
        }

        switch (sideDish) {
            case 0:
                sideDishCost = 0.00;
                sideDishName = "No order";
                break;
            case 1:
                sideDishCost = 0.79;
                sideDishName = "Rice Cracker";
                break;
            case 2:
                sideDishCost = 4.59;
                sideDishName = "No-Salt Fries";
                break;
            case 3:
                sideDishCost = 3.99;
                sideDishName = "Zucchini";
                break;
            case 4:
                sideDishCost = 2.99;
                sideDishName = "Brown Rice";
                break;
            default:
                System.out.println("Invalid item selection.");
                break;
        }

        switch (drink) {
            case 0:
                drinkCost = 0.00;
                drinkName = "No order";
                break;
            case 1:
                drinkCost = 1.99;
                drinkName = "Cafe Mocha";
                break;
            case 2:
                drinkCost = 1.99;
                drinkName = "Cafe Latte";
                break;
            case 3:
                drinkCost = 2.49;
                drinkName = "Espresso";
                break;
            case 4:
                drinkCost = 0.99;
                drinkName = "Oolong Tea";
                break;
            default:
                System.out.println("Invalid item selection.");
                break;
        }

        cost = entreeCost + sideDishCost + drinkCost;

        return cost;
    }
}
