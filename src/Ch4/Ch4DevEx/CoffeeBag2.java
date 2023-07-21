/*
*Write a program that accepts the unit weight of a bag of coffee in pounds
and the number of bags sold and displays the total price of the sale,
computed as follows:
    totalPrice = bagWeight * numberOfBags * pricePerLb;
    totalPriceWithTax = totalPrice + totalPrice * tax rate;
Display the result in the following manner:
    Number of bags sold: 32
    Weight per bag: 5 lb
    Price per pound: $5.99
    Sales tax: 7.25%
    Total price: $ 1027.88
Define and use a programmer-defined CoffeeBag class. Include class
constants for the price per pound and tax rate with the values $5.99 per
pound and 7.25 percent, respectively.
*/

package Ch4.Ch4DevEx;

public class CoffeeBag2 {
    // data members
    public static final double PRICE_PER_LB = 5.99;
    public static final double TAX_RATE = 0.0725;
    private double totalPrice, totalPriceWithTax;
    private double bagWeight;
    private int numberOfBags;

    // constructor
    public CoffeeBag2() {
        totalPrice = 0;
        totalPriceWithTax = 0;
        bagWeight = 0;
        numberOfBags = 0;
    }

    // main method
    public static void main(String[] args) {
        CoffeeBag2 cb = new CoffeeBag2();
        cb.setBagWeight(5);
        cb.setNumberOfBags(32);

        System.out.println(
                "Number of bags sold: " + cb.getNumberOfBags() + "\n" +
                        "     Weight per bag: " + cb.getBagWeight() + "\n" +
                        "    Price per pound: " + cb.PRICE_PER_LB + "\n" +
                        "          Sales tax: " + cb.TAX_RATE + "\n" + "\n" +
                        "        Total price: $ " + cb.getTotalPrice()
        );
    }

    // returns the weight per bag
    public double getBagWeight() {
        return bagWeight;
    }

    // returns the number of bags
    public int getNumberOfBags() {
        return numberOfBags;
    }

    // returns the total price
    public double getTotalPrice() {
        totalPrice = bagWeight * numberOfBags * PRICE_PER_LB;
        totalPriceWithTax = totalPrice + totalPrice * TAX_RATE;
        return totalPriceWithTax;
    }

    // assigns the weight per bag
    public void setBagWeight(double givenBagWeight) {
        bagWeight = givenBagWeight;
    }

    // assigns the number of bags
    public void setNumberOfBags(int givenNumberOfBags) {
        numberOfBags = givenNumberOfBags;
    }
}