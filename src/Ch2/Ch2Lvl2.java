/*
 * Chapter 2 Level 2 Exercises
 * */

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ch2Lvl2 {
    public static void main(String[] args) {
        Ex26();
    }
    public static void Ex22() {
        Scanner scanner = new Scanner(System.in);
        JFrame frame = new JFrame();

        String title, W, H;

        System.out.print("Enter title: ");
        title = scanner.next();
        System.out.print("Enter W: ");
        W = scanner.next();
        System.out.print("Enter H: ");
        H = scanner.next();

        frame.setSize(Integer.parseInt(W), Integer.parseInt(H));
        frame.setTitle(title);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void Ex23() {
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

        System.out.print(sdf.format(currentTime).toUpperCase());
    }
    public static void Ex24() {
        JFrame frame = new JFrame();

        frame.setTitle("My First Frame");
        frame.setSize(300, 200);
        frame.setLocation(100, 50);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void Ex25() {
        JFrame frame = new JFrame();

        frame.setTitle("My First Frame");
        frame.setSize(300, 200);
        frame.setLocation(100, 50);
        frame.setVisible(true);

        try {Thread.sleep(500);} catch(Exception e) { }
        frame.setVisible(false);
        try {Thread.sleep(500);} catch(Exception e) { }
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void Ex26() {
        Scanner scanner = new Scanner(System.in);

        String text;

        text = scanner.nextLine();

        System.out.println(text.substring(0, text.indexOf("!")-1));
        System.out.println(text.substring(text.indexOf("!")+1));
    }
}
