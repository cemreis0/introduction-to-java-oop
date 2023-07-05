import java.text.DecimalFormat;
import java.util.*;

public class NumericalData {
    public static void main(String[] args) {
    }
    public static void Ch3Circle() {
        final double PI = 3.14159;
        double radius, area, circumference;
        DecimalFormat df = new DecimalFormat();

        radius = 2.35;

        // Compute the area and circumference
        area = PI * radius * radius;
        circumference = 2.0 * PI * radius;

        System.out.println( "Given Radius   " + "\t" + df.format(radius) + "\n" +
                            "Area          " + "\t" + df.format(area) + "\n" +
                            "Circumference " + "\t" + df.format(circumference));
    }
    public static void Ch3Circle2() {
        // Changes in Ch3Circle2 has been made to Ch3Circle
    }
    public static void Ch3Circle3() {
        final String NEW_LINE = "\n";
        final String TAB = "\t";
        final double PI = 3.14159;

        double radius, area, circumference;
        DecimalFormat df = new DecimalFormat();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter radius: ");
        radius = scanner.nextDouble();

        // Compute the area and circumference
        area = PI * radius * radius;
        circumference = 2.0 * PI * radius;

        System.out.println( "Given Radius  " + TAB + df.format(radius) + NEW_LINE +
                            "Area          " + TAB + df.format(area) + NEW_LINE +
                            "Circumference " + TAB + df.format(circumference));

    }
    public static void CH3_5QC3() {
        /*. Chapter 3.5 Quick Check 3 Problem Statement:
            Using one print statement, output the following:
                Hello, world!
                My favorite Ben Franklin quote:

                    An investment in knowledge
                    always pays the best interest.
         */
        final String NEW_LINE = "\n";
        final String TAB = "\t";

        System.out.print("Hello, world!" + NEW_LINE
                + TAB + "My favorite Ben Franklin quote:" + NEW_LINE + NEW_LINE
                + TAB + TAB + "An investment in knowledge" + NEW_LINE
                + TAB + TAB + "always pays the best interest.");
    }
    public static void CH3_6QC1() {
        /*. Chapter 3.6 Quick Check 1 Problem Statement:
            Write a code to input the height of a user in feet (int) and inches (int).
         */
        Scanner scanner = new Scanner(System.in);
        int heightInFt, heightInCm;

        System.out.print("Enter height in feet: ");
        heightInFt = scanner.nextInt();
        System.out.print("Enter height in cm: ");
        heightInCm = scanner.nextInt();
        System.out.println(heightInFt + " " +heightInCm);
    }
    public static void CH3_6QC2() {
        /* Chapter 3.6 Quick Check 2 Problem Statement:
           Write a code to input the full name of a person and his or her age. The full
           name of a person includes the first name and the last name.
        */
        Scanner scanner = new Scanner(System.in);
        String fullName;
        int age;

        System.out.print("Enter your full name (first middle last): ");
        fullName = scanner.nextLine();
        System.out.print("Enter your age: ");
        age = scanner.nextInt();

        System.out.println("Your full name is " + fullName + ". Your age is " + age + "." );
    }
    public static void CH3_6QC3() {
        /* Chapter 3.6 Quick Check 3 Problem Statement:
           Write a code that creates a Scanner object and sets its delimiter to the pound sign.
        */
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("#");

        String text;

        System.out.print("Enter text: ");
        text = scanner.next();

        System.out.print(text);
    }
    public static void Ch3PoleHeight() {
        // Chapter 3 Sample Program: Estimate the Pole Height
        double height;      // height of the pole
        double distance;    // distance between points A and B
        double alpha;       // angle measured at point A
        double beta;        // angle measured at point B
        double alphaRad;    // alpha angle in radians
        double betaRad;     // beta angle in radians

        Scanner scanner = new Scanner(System.in);

        // get three inputs from the user
        System.out.print("Angle alpha (in degrees): ");
        alpha = scanner.nextDouble();
        System.out.print("Angle beta (in degrees): ");
        beta = scanner.nextDouble();
        System.out.print("Distance between points A and B (m): ");
        distance = scanner.nextDouble();

        // compute the angles in radians
        alphaRad = Math.toRadians(alpha);
        betaRad = Math.toRadians(beta);

        height = (distance * Math.sin(alphaRad) * Math.sin(betaRad)) /
                Math.sqrt(Math.sin(alphaRad + betaRad) * Math.sin(alphaRad - betaRad));

        // format the output
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("The height of the pole is " + df.format(height) + " meters." );
    }
    public static void RandomNumberGeneration() {
        Random random = new Random();

        System.out.print(random.nextInt(32-12+1) + 12); // minimum value is set adding it to the expression
        // there's no lower bound argument
    }
    public static void Ch3SelectWinner() {
        /*
        * Chapter 3.7 Problem Statement:
        * Let’s write a short program that selects a winner among the party goers of the
        annual spring fraternity dance. The party goers will receive numbers M + 1, M + 2,
        M + 3, and so on, as they enter the house. The starting value M is determined by the
        fraternity president. The last number assigned is M + N if there are N party goers. At
        the end of the party, we run the program that will randomly select the winning number from the range of M + 1 and M + N.:
        * */
        int startingNumber, count, winningNumber, min, max;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting number: ");
        startingNumber = scanner.nextInt();
        System.out.print("Enter the number of party goers: ");
        count = scanner.nextInt();

        min = startingNumber + 1;
        max = startingNumber + count;

        winningNumber = random.nextInt(max-min+1) + min;

        System.out.print("The winning number is " + winningNumber + ".");
    }
}
