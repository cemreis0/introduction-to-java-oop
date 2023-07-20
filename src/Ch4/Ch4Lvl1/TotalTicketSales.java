/*
Chapter 4 Exercise 6

Write a program that computes the total ticket sales of a concert. There are
three types of seats: A, B, and C. The program accepts the number of
tickets sold and the price of a ticket for each of the three types of seats. The
total sales are computed as follows:
    totalSales = numberOfA_Seats * pricePerA_Seat +
    numberOfB_Seats * pricePerB_Seat +
    numberOfC_Seats * pricePerC_Seat;
Write this program, using only one class, the main class of the program.
*/

package Ch4.Ch4Lvl1;

public class TotalTicketSales {
    // data members
    private int numberOfA_Seats, numberOfB_Seats, numberOfC_Seats; // numbers of each seat type
    private double pricePerA_Seat, pricePerB_Seat, pricePerC_Seat; // price per each seat type
    private double total; // total sales

    // constructor
    public TotalTicketSales(double priceA, double priceB, double priceC) {
        pricePerA_Seat = priceA; // price is set once for each seat type, through constructor
        pricePerB_Seat = priceB;
        pricePerC_Seat = priceC;
        numberOfA_Seats = 0; // number of seats can be updated, no seats reserved initially
        numberOfB_Seats = 0;
        numberOfC_Seats = 0;
    }

    // main method
    public static void main(String[] args) {
        // sample

        // declaring and creating the instance
        TotalTicketSales sales = new TotalTicketSales(10.0, 15.0, 17.5);

        // setting the number of seats sold
        sales.setNumberOfA_Seats(57);
        sales.setNumberOfB_Seats(45);
        sales.setNumberOfC_Seats(66);

        // echo printing the input and computed output
        System.out.println(
                "Number of seats of type A sold: " + sales.getNumberOfA_Seats() +
                        " ($" + sales.getPricePerA_Seat() + " each)" + "\n" +
                "Number of seats of type B sold: " + sales.getNumberOfB_Seats() +
                        " ($" + sales.getPricePerB_Seat() + " each)" + "\n" +
                "Number of seats of type C sold: " + sales.getNumberOfC_Seats() +
                        " ($" + sales.getPricePerC_Seat() + " each)" + "\n" +
                "Total: $" + sales.getTotal()
                );
    }

    // returns the number of tickets of seats of type A sold
    public int getNumberOfA_Seats() {
        return numberOfA_Seats;
    }
    // returns the number of tickets of seats of type B sold
    public int getNumberOfB_Seats() {
        return numberOfB_Seats;
    }
    // returns the number of tickets of seats of type C sold
    public int getNumberOfC_Seats() {
        return numberOfC_Seats;
    }
    // returns the price per seat of type A
    public double getPricePerA_Seat() {
        return pricePerA_Seat;
    }
    // returns the price per seat of type A
    public double getPricePerB_Seat() {
        return pricePerB_Seat;
    }
    // returns the price per seat of type A
    public double getPricePerC_Seat() {
        return pricePerC_Seat;
    }
    // computes and returns the total sales
    public double getTotal() {
        total = numberOfA_Seats * pricePerA_Seat + numberOfB_Seats * pricePerB_Seat + numberOfC_Seats * pricePerC_Seat;
        return total;
    }

    // assigns the number of tickets of seats of type A sold
    public void setNumberOfA_Seats(int numberOfSeats) {
        numberOfA_Seats = numberOfSeats;
    }
    // assigns the number of tickets of seats of type B sold
    public void setNumberOfB_Seats(int numberOfSeats) {
        numberOfB_Seats = numberOfSeats;
    }
    // assigns the number of tickets of seats of type C sold
    public void setNumberOfC_Seats(int numberOfSeats) {
        numberOfC_Seats = numberOfSeats;
    }
}
