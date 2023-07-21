/*
Chapter 4 Exercise 12

Write a program that displays the recommended weight (kg), given the
user’s age and height (cm). The formula for calculating the recommended
weight is
recommendedWeight = (height - 100 + age / 10) * 0.90
Define a service class named Height and include an appropriate method for
getting a recommended weight of a designated height.

(This exercise is a bit unnecessary in my opinion.)
*/

package Ch4.Ch4Lvl2;

public class RecommendedWeight {
    // data members
    private double rw; // recommended weight
    private Height h = new Height(175);

    // constructor
    public RecommendedWeight() {

    }

    // main method
    public static void main(String[] args) {
       RecommendedWeight rw = new RecommendedWeight();
       rw.describeProgram();
       rw.getRw();
    }

    // prints out the description of the program
    private void describeProgram() {
        System.out.println("This program calculates the recommended weight for a given height.");
    }

    private void getRw() {
        System.out.println("RW: " + h.calculateRw());
    }
}

class Height {
    // data members
    private double height;

    // constructor
    public Height(double givenHeight) {
        height = givenHeight;
    }

    // computes the recommended weight
    public double calculateRw() {
        double rw;
        double age = 21;
        rw = (height - 100 + age / 10) * 0.90;
        return rw;
    }
}