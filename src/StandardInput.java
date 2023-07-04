import java.util.Scanner;

public class StandardInput {
    public static void main(String[] args) {
        qc();
    }

    public static void standardInput() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, fullName, firstName2, lastName2;
        System.out.print("Enter your first name: ");
        firstName = scanner.next();
        System.out.print("Enter your last name: ");
        lastName = scanner.next();
        System.out.println("Your full name is " + firstName + " " + lastName + ".");
        System.out.print("Enter your full name: ");
        fullName = scanner.next(); // space in the full name is a delimiter
        System.out.println("Your full name is " + fullName + ".");
        System.out.print("Enter your full name: ");
        firstName2 = scanner.next(); // the right way to get
        lastName2 = scanner.next(); // the full name is like this
        System.out.println("Your full name is " + firstName2 + " " + lastName2 + ".");
    }

    public static void newDelimiter() {
        Scanner scanner = new Scanner(System.in);
        String quote;
        System.out.println("Enter your favorite quote: ");
        quote = scanner.nextLine();
        System.out.println("Quote is " + quote);
    }
    public static void qc() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your last name: ");
        String lastName = scanner.next();
        System.out.print("Your last name is " + lastName + ".");
    }
}
