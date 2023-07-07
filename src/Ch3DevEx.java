import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ch3DevEx {
    public static void main(String[] args) {
        Ex30();
    }
    public static void Ex28() {
        /*  Develop an application that reads a purchase price and an amount tendered
            and then displays the change in dollars, quarters, dimes, nickels, and
            pennies. Two input values are entered in cents, for example, 3480 for $34.80
            and 70 for $0.70. Display the output in the following format:

                 Purchase Price: $ 34.80
                Amount Tendered: $ 40.00
                 Your change is: $ 5.20

                 5 one-dollar bill(s)
                 0 quarter(s)
                 2 dime(s)
                 0 nickel(s)
                 0 penn(y/ies)

                Thank you for your business. Come back soon

            Notice the input values are to be entered in cents (int data type), but
            the echo printed values must be displayed with decimal points (float
            data type).
         */

        // cent equivalents of coins
        final int PENNY_TO_CENTS = 1;
        final int NICKEL_TO_CENTS = 5;
        final int DIME_TO_CENTS = 10;
        final int QUARTER_TO_CENTS = 25;
        final int DOLLAR_TO_CENTS = 100;

        // new line constant
        final String NEW_LINE = "\n";

        // values of coins
        int penny, nickel, dime, quarter, dollar;

        // input values
        int price, tender; // data type is int, they are entered in cents

        // change variables, changeAtFirst is displayed in output
        int change, changeAtFirst;

        // these values need to be displayed in dollars, so there will be typecasting
        double priceInDollars, tenderInDollars, changeAtFirstInDollars;

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // read input from the user
        System.out.print("Enter price: $ ");
        price = scanner.nextInt();
        System.out.print("Enter tender: $ ");
        tender = scanner.nextInt();

        // compute change in cents
        // changeAtFirst is used to display the change in output
        change = tender - price;
        changeAtFirst = change;

        // compute the amount of coins
        // approach: filter from high to low, dollar to penny, the value of change is shrunk each time, if possible
        dollar = change / DOLLAR_TO_CENTS;
        change = change % DOLLAR_TO_CENTS;
        quarter = change / QUARTER_TO_CENTS;
        change = change % QUARTER_TO_CENTS;
        dime = change / DIME_TO_CENTS;
        change = change % DIME_TO_CENTS;
        nickel = change / NICKEL_TO_CENTS;
        change = change % NICKEL_TO_CENTS;
        penny = change / PENNY_TO_CENTS;

        // convert the price, tender and changeAtFirst from cents to dollars
        priceInDollars = (double) price / 100;
        tenderInDollars = (double) tender / 100;
        changeAtFirstInDollars = (double) changeAtFirst / 100;

        // output
        System.out.println(
                "Purchase Price:    $ " + df.format(priceInDollars) + NEW_LINE +
                "Amount Tendered:   $ " + df.format(tenderInDollars) + NEW_LINE + NEW_LINE +
                "Your change is:    $ " + df.format(changeAtFirstInDollars) + NEW_LINE + NEW_LINE +
                "                   " + dollar + " one dollar bill(s)" + NEW_LINE +
                "                   " + quarter + " quarter(s)" + NEW_LINE +
                "                   " + dime + " dime(s)" + NEW_LINE +
                "                   " + nickel + " nickel(s)" + NEW_LINE +
                "                   " + penny + " penn(y/ies)" + NEW_LINE + NEW_LINE +
                "Thank you for your business. Come back soon."
        );
    }
    public static void Ex29() {
        /*
        MyJava Coffee Outlet runs a catalog business. It sells only one type of
        coffee beans, harvested exclusively in the remote area of Irian Jaya. The
        company sells the coffee in 2-lb bags only, and the price of a single 2-lb
        bag is $5.50. When a customer places an order, the company ships the
        order in boxes. The boxes come in three sizes: the large box holds 20 bags
        of 2 lb, the medium 10 bags, and the small 5 bags. The cost of a large
        box is $1.80; a medium box, $1.00; and a small box, $0.60. The order is
        shipped in the least expensive manner. For example, the order of 52 bags
        will be shipped in four boxes: two large, one medium, and one small. The
        rule for packing is to fill the large and medium boxes completely; that is,
        the box is fully packed. Only the small boxes can have empty spaces. For
        example, to ship 52 bags, you could have used 3 large boxes, but that
        would leave the third box not fully packed. Develop a program that
        computes the total cost of an order. Display the output in the following
        format:

        Number of Bags Ordered: 52 - $ 286.00
        Boxes Used:
                    2 Large - $3.60
                    1 Medium - $1.00
                    1 Small - $0.60
        Your total cost is: $ 291.20
        */

        // price of coffee bag and boxes
        final double COFFEE_BAG_PRICE = 5.50;
        final double SMALL_BOX_PRICE = 0.60;
        final double MEDIUM_BOX_PRICE = 1.00;
        final double LARGE_BOX_PRICE = 1.80;

        // constants
        final String NEW_LINE = "\n";

        // number of bags the boxes can carry
        final int SMALL_BOX_SIZE = 5;
        final int MEDIUM_BOX_SIZE = 10;
        final int LARGE_BOX_SIZE = 20;

        // bags is input, and bagsAtFirst to display in output
        int bags, bagsAtFirst;

        // output values
        int medium, large, small; // number of bags used
        double price, total; // price of coffee, total price with boxes

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // read input
        System.out.print("How many boxes would you like to order (2 lb each): ");
        bags = scanner.nextInt();

        // assign bags to bagsAtFirst, the value of the bags get smaller with computation, to display the unchanged value
        // in output bagsAtFirst is used
        bagsAtFirst = bags;

        // compute the boxes needed
        // approach: filter from large to small, the number of bags gets divided each time, if possible
        // and the remainder is passed down to a smaller box
        large = bags / LARGE_BOX_SIZE;
        bags = bags % LARGE_BOX_SIZE;
        medium = bags / MEDIUM_BOX_SIZE;
        bags = bags % MEDIUM_BOX_SIZE;
        small = (int) Math.ceil((double) bags / SMALL_BOX_SIZE);

        // compute price and total
        price = bagsAtFirst * COFFEE_BAG_PRICE;
        total = price + (large * LARGE_BOX_PRICE) + (medium * MEDIUM_BOX_PRICE) + (small * SMALL_BOX_PRICE);

        // output
        System.out.print(
                "Number of Bags Ordered: " + bagsAtFirst + " - $ " + df.format(price) + NEW_LINE +
                "Boxes Used:" + NEW_LINE +
                "           " + large +  " Large - " + df.format(large * LARGE_BOX_PRICE) + NEW_LINE +
                "           " + medium + " Medium - " + df.format(medium * MEDIUM_BOX_PRICE) + NEW_LINE +
                "           " + small + " Small - " + df.format(small * SMALL_BOX_PRICE) + NEW_LINE +
                "Your total cost is: $ " + df.format(total)
        );
    }
    public static void Ex30() {
        /*
        Exercise 29 Statement:
        MyJava Coffee Outlet runs a catalog business. It sells only one type of
        coffee beans, harvested exclusively in the remote area of Irian Jaya. The
        company sells the coffee in 2-lb bags only, and the price of a single 2-lb
        bag is $5.50. When a customer places an order, the company ships the
        order in boxes. The boxes come in three sizes: the large box holds 20 bags
        of 2 lb, the medium 10 bags, and the small 5 bags. The cost of a large
        box is $1.80; a medium box, $1.00; and a small box, $0.60. The order is
        shipped in the least expensive manner. For example, the order of 52 bags
        will be shipped in four boxes: two large, one medium, and one small. The
        rule for packing is to fill the large and medium boxes completely; that is,
        the box is fully packed. Only the small boxes can have empty spaces. For
        example, to ship 52 bags, you could have used 3 large boxes, but that
        would leave the third box not fully packed. Develop a program that
        computes the total cost of an order. Display the output in the following
        format:

        Number of Bags Ordered: 52 - $ 286.00
        Boxes Used:
        2 Large - $3.60
        1 Medium - $1.00
        1 Small - $0.60
        Your total cost is: $ 291.20
        */
        
        /*
        Repeat Exercise 29, but this time, accept the date when the order is placed
        and display the expected date of arrival. The expected date of arrival is two
        weeks (14 days) from the date of order. The order date is entered as a
        single string in the MM/dd/yyyy format. For example, November 1, 2008
        is entered as 11/01/2008. There will be exactly two digits each for the
        month and day and four digits for the year. Display the output in the
        following format:

        Number of Bags Ordered: 52 - $ 286.00
        Boxes Used:
                    2 Large - $3.60
                    1 Medium - $1.00
                    1 Small - $0.60
        Your total cost is: $ 291.20
        Date of Order:                  November 1, 2008
        Expected Date of Arrival:       November 15, 2008
         */

        // price of coffee bag and boxes
        final double COFFEE_BAG_PRICE = 5.50;
        final double SMALL_BOX_PRICE = 0.60;
        final double MEDIUM_BOX_PRICE = 1.00;
        final double LARGE_BOX_PRICE = 1.80;

        // constants
        final String NEW_LINE = "\n";

        // number of bags the boxes can carry
        final int SMALL_BOX_SIZE = 5;
        final int MEDIUM_BOX_SIZE = 10;
        final int LARGE_BOX_SIZE = 20;

        // bags is input, and bagsAtFirst to display in output
        int bags, bagsAtFirst;

        // date values and computations
        // approach: get current date, which is dateOfOrder, get dateOfArrival, make it equal to dateOfOrder (clone)
        // then add 14 days to addOfArrival
        GregorianCalendar dateOfOrder = new GregorianCalendar();
        GregorianCalendar dateOfArrival;
        dateOfArrival = (GregorianCalendar) dateOfOrder.clone();
        dateOfArrival.add(Calendar.DATE, 14);

        // output values
        int medium, large, small; // number of bags used
        double price, total; // price of coffee, total price with boxes

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");

        // read input
        System.out.print("How many boxes would you like to order (2 lb each): ");
        bags = scanner.nextInt();

        // assign bags to bagsAtFirst, the value of the bags get smaller with computation, to display the unchanged value
        // in output bagsAtFirst is used
        bagsAtFirst = bags;

        // compute the boxes needed
        // approach: filter from large to small, the number of bags gets divided each time, if possible
        // and the remainder is passed down to a smaller box
        large = bags / LARGE_BOX_SIZE;
        bags = bags % LARGE_BOX_SIZE;
        medium = bags / MEDIUM_BOX_SIZE;
        bags = bags % MEDIUM_BOX_SIZE;
        small = (int) Math.ceil((double) bags / SMALL_BOX_SIZE);

        // compute price and total
        price = bagsAtFirst * COFFEE_BAG_PRICE;
        total = price + (large * LARGE_BOX_PRICE) + (medium * MEDIUM_BOX_PRICE) + (small * SMALL_BOX_PRICE);

        // date computations


        // output
        System.out.print(
                "Number of Bags Ordered: " + bagsAtFirst + " - $ " + df.format(price) + NEW_LINE +
                        "Boxes Used:" + NEW_LINE +
                        "           " + large +  " Large - " + df.format(large * LARGE_BOX_PRICE) + NEW_LINE +
                        "           " + medium + " Medium - " + df.format(medium * MEDIUM_BOX_PRICE) + NEW_LINE +
                        "           " + small + " Small - " + df.format(small * SMALL_BOX_PRICE) + NEW_LINE +
                "Your total cost is: $ " + df.format(total) + NEW_LINE +
                "Date of Order:             " + sdf.format(dateOfOrder.getTime()) + NEW_LINE +
                "Expected Date of Arrival:  " + sdf.format(dateOfArrival.getTime())
        );
    }
    public static void Ex31() {
        // no package called galapagos
    }
    public static void Ex32() {
        // no package called galapagos
    }
}
