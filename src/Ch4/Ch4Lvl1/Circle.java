/*
Chapter 4 Exercise 9

Write a program that computes the area of a circular region (the shaded area
in the diagram), given the radii of the inner and the outer circles, ri and ro,
respectively.
We compute the area of the circular region by subtracting the area of the
inner circle from the area of the outer circle. Define a Circle class that has
methods to compute the area and circumference. You set the circle’s radius
with the setRadius method or via a constructor.
*/

package Ch4.Ch4Lvl1;

public class Circle {
    // data members
    public double radius; // the radius of the circle

    // constructor
    public Circle(double rad) {
        radius = rad;
    }

    // main method
    public static void main(String[] args) {
        // sample

        double region; // area of the outer circular region

        // declare Circle instances
        Circle c1, c2; // c1 - bigger circle, c2 - smaller circle

        // create Circle objects
        c1 = new Circle(12.5);
        c2 = new Circle(7.4);

        // compute the outer circular region
        region = c1.getArea() - c2.getArea();

        // display results
        System.out.println(
                "Area of the outer region of two intersecting" + "\n" +
                "circles with radius " + c1.radius + " and " + c2.radius + "\n" +
                "is " + region
        );
    }

    //returns the circumference of this circle
    private double getCircumference() {
        double circumference;
        circumference = Math.PI * 2 * radius;
        return circumference;
    }
    // returns the area of this circle
    private double getArea() {
        double area;
        area = Math.PI * radius * radius;
        return area;
    }
}
