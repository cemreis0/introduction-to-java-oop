/*
Chapter 5 Development Exercises
*/

package Ch5.Ch5DevEx;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ch5DevEx {
    public static void main(String[] args) {
        Ex18();
    }

    public static void Ex18() {
        // exercises 18 and 19
        CoffeeOrderHandler coh = new CoffeeOrderHandler();
        coh.setNumberOfBags(43);

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println(
            "Number of Bags Ordered: " + coh.getNumberOfBags() +" - $ " + df.format(coh.getPrice()) + "\n" +
                    "      Discount: " + coh.getDiscount() * 100 + "% - $ " + df.format(coh.getTotal() * coh.getDiscount()) + "\n" +
                "Boxes Used:" + "\n" +
                "           " + coh.getNumberOfLargeBoxes() +  " Large - " + df.format(coh.getNumberOfLargeBoxes() * coh.getLargeBoxPrice()) + "\n" +
                "           " + coh.getNumberOfMediumBoxes() + " Medium - " + df.format(coh.getNumberOfMediumBoxes() * coh.getMediumBoxPrice()) + "\n" +
                "           " + coh.getNumberOfSmallBoxes() + " Small - " + df.format(coh.getNumberOfSmallBoxes() * coh.getSmallBoxPrice()) + "\n" +
                "Your total cost is: $ " + df.format(coh.getTotal()) + "\n" +
                "Date of Order:             " + coh.getOrderDate() + "\n" +
                "Expected Date of Arrival:  " + coh.getArrivalDate()
        );
    }
}

class CoffeeOrderHandler {
    // data members
    private int numberOfBags; // number of CoffeeBags ordered
    private int numberOfSmallBoxes, numberOfMediumBoxes, numberOfLargeBoxes; // number of boxes necessary
    // CoffeeBox instances by size and price
    private static CoffeeBox smallBox = new CoffeeBox(5, 0.60);
    private static CoffeeBox mediumBox = new CoffeeBox(10, 1.00);
    private static CoffeeBox largeBox = new CoffeeBox(20, 1.80);
    // Standard CoffeeBag
    private CoffeeBag coffeeBag = new CoffeeBag(5.50);
    // Dates
    GregorianCalendar dateOfOrder = new GregorianCalendar();
    GregorianCalendar dateOfArrival;

    // constructor
    public CoffeeOrderHandler() {
        numberOfBags = 0;
        numberOfSmallBoxes = 0;
        numberOfMediumBoxes = 0;
        numberOfLargeBoxes = 0;
    }

    // computes the number of each box necessary
    private void computeBoxes(int numberOfBags) {
        int numberOfBagsToCompute; // used to calculate the number of boxes
        numberOfBagsToCompute = numberOfBags;
        numberOfLargeBoxes = numberOfBagsToCompute / largeBox.size;
        numberOfBagsToCompute = numberOfBagsToCompute % largeBox.size;
        numberOfMediumBoxes = numberOfBagsToCompute / mediumBox.size;
        numberOfBagsToCompute = numberOfBagsToCompute % mediumBox.size;
        numberOfSmallBoxes = (int) Math.ceil((double) numberOfBagsToCompute / smallBox.size);
    }
    // returns the number of CoffeeBags
    public int getNumberOfBags() {
        return numberOfBags;
    }
    // returns the number of small boxes
    public int getNumberOfSmallBoxes() {
        return numberOfSmallBoxes;
    }
    // returns the number of medium boxes
    public int getNumberOfMediumBoxes() {
        return numberOfMediumBoxes;
    }
    // returns the number of large boxes
    public int getNumberOfLargeBoxes() {
        return numberOfLargeBoxes;
    }
    // returns the price of large box
    public double getLargeBoxPrice() {
        return largeBox.price;
    }
    // returns the price of medium box
    public double getMediumBoxPrice() {
        return mediumBox.price;
    }
    // returns the price of small box
    public double getSmallBoxPrice() {
        return smallBox.price;
    }
    // returns the price
    public double getPrice() {
        double price;
        price = numberOfBags * coffeeBag.getPrice();
        return price;
    }
    // returns the total
    public double getTotal() {
        double total;
        total = getPrice() + (numberOfLargeBoxes * largeBox.getPrice())
                +
                (numberOfMediumBoxes * mediumBox.getPrice())
                +
                (numberOfSmallBoxes * smallBox.getPrice());
        total = total - total*getDiscount();
        return total;
    }
    public double getDiscount() {
        double discount;
        int bags = getNumberOfBags();
        if (bags >= 25 && bags < 50) {
            discount = 0.05;
        } else if (bags >= 50 && bags < 100) {
            discount = 0.10;
        } else if (bags >= 100 && bags < 150) {
            discount = 0.15;
        } else if (bags >= 150 && bags < 200) {
            discount = 0.20;
        } else if (bags >= 200 && bags < 300) {
            discount = 0.25;
        } else if (bags >= 300) {
            discount = 0.30;
        } else {
            discount = 0;
        }
        return discount;
    }
    // returns the date of order
    public String getOrderDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        return sdf.format(dateOfOrder.getTime());
    }
    // returns the expected date of arrival
    public String getArrivalDate() {
        getOrderDate();
        dateOfArrival = (GregorianCalendar) dateOfOrder.clone();
        dateOfArrival.add(Calendar.DATE, 14);
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        return sdf.format(dateOfArrival.getTime());
    }
    // sets the number of bags ordered
    public void setNumberOfBags(int givenNumberOfBags) {
        numberOfBags = givenNumberOfBags;
        computeBoxes(numberOfBags);
    }
}

class CoffeeBox {
    // data members
    public int size; // number of CoffeeBags that fit in this CoffeeBox
    public double price; // price per CoffeeBox

    // constructor
    public CoffeeBox(int givenSize, double givenPrice) {
        size = givenSize;
        price = givenPrice;
    }

    // returns the size of this CoffeeBox
    public int getSize() {
        return size;
    }
    // returns the price of this CoffeeBox
    public double getPrice() {
        return price;
    }
}

class CoffeeBag {
    // data members
    public double price; // price per CoffeeBag

    // constructor
    CoffeeBag(double givenPrice) {
        price = givenPrice;
    }

    // returns the price of this CoffeeBag
    public double getPrice() {
        return price;
    }
}