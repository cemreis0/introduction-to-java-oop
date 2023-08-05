/*
* This program computes the projectile of a watermelon fired from a cannon.
* The (x, y) coordinate of the watermelon at time t is given by the equations:
* x = V * cos(α) * t
* y = V * sin(α) * t - (1/2) * g * t^2
* where:
* V is the initial velocity (m/s),
* α (alpha) is the initial angle (degrees),
* g is the acceleration due to gravity (9.8 m/s^2).
*
* The program should repeat the computation until the user wants to quit.
* The program outputs the (x, y) coordinate value for every second (t = 0, 1, 2, ...),
* until the y value becomes 0 or less (ground level).
*
* To use the cos and sin methods of the Math class, don't forget that you
* have to convert the input angle given in degrees to radians.
* You can convert a degree to equivalent radians by using the following:
* Radian = Degree * (π / 180)
* or by calling the toRadians method of the Math class.
*
* Note: Air resistance is not considered in the formula, and it is assumed that the watermelon will not get smashed upon firing.
*/


package Ch6.Ch6DevEx;

import java.util.Scanner;

public class Projectile {
    public static final double G = 9.8; // gravitational acceleration
    // data members
    public double angle; // shooting angle
    public double velocity; // initial velocity

    // constructor
    public Projectile(double givenAngle, double givenVelocity) {
        angle = Math.toRadians(givenAngle);
        velocity = givenVelocity;
    }

    // main method
    public static void main(String[] args) {
        double angle, velocity; // angle and velocity values that will be passed when the object is created

        Projectile projectile;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shooting angle in (degrees): ");
        angle = scanner.nextDouble();
        System.out.print("Enter shooting velocity (m/s): ");
        velocity = scanner.nextDouble();

        projectile = new Projectile(angle, velocity);

        projectile.simulate();
    }

    // simulate the projectile motion
    public void simulate() {
        double x, y; // coordinates
        int time = 0; // timestamps

        do {
            x = calculateX(time);
            y = calculateY(time);

            if (y < 0) { // termination condition is the y coordinate
                break;
            }

            System.out.println(
                    "t: " + time + "\n" +
                    "x: " + x + "\n" +
                    "y: " + y + "\n"
            );
            time++;
        } while (y >= 0);

    }

    // calculate the x coordinate at time
    private double calculateX(int time) {
        double x;
        x = velocity * Math.cos(angle) * time;
        return x;
    }

    // calculate the y coordinate at time
    private double calculateY(int time) {
        double y;
        y = (velocity * Math.sin(angle) * time) - (G*time*time/2);
        return y;
    }
}
