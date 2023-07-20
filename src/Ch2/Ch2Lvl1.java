/*
 * Chapter 2 Level 1 Exercises
 * */


import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ch2Lvl1 {
    public static void main(String[] args) {
        Ex21();
    }
    public static void Ex17() {
        JFrame frame = new JFrame();

        frame.setSize(800, 600);
        frame.setTitle("Welcome to Java");
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void Ex18() {
        JFrame frame = new JFrame();
        Scanner scanner = new Scanner(System.in);

        String firstName, lastName;

        System.out.print("Enter your first name: ");
        firstName = scanner.next();
        System.out.print("Enter your last name: ");
        lastName = scanner.next();

        frame.setSize(800, 600);
        frame.setTitle(lastName + ", " + firstName);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void Ex19() {
        Scanner scanner = new Scanner(System.in);

        String firstName, middleName, lastName;

        System.out.print("Enter your first name: ");
        firstName = scanner.next();
        System.out.print("Enter your middle name: ");
        middleName = scanner.next();
        System.out.print("Enter your last name: ");
        lastName = scanner.next();

        System.out.print(firstName + " " + middleName.charAt(0) + ". " + lastName);
    }
    public static void Ex20() {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        System.out.print(sdf.format(today));
    }
    public static void Ex21() {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM dd, yyyy");

        System.out.print(sdf.format(today));
    }
}
