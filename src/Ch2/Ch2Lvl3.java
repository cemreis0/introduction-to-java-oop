/*
 * Chapter 2 Level 3 Exercises
 * */

import java.util.*;

public class Ch2Lvl3 {
    public static void main(String[] args) {
        Ex29();
    }
    public static void Ex27() {
        Scanner scanner = new Scanner(System.in);
        String text;

        System.out.print("Enter text: ");
        text = scanner.nextLine();

        System.out.println(text.length());
        System.out.println(text.charAt(0));
        System.out.println(text.charAt(text.length()-1));
    }
    public static void Ex28() {
        Scanner scanner = new Scanner(System.in);
        String word;

        System.out.print("Enter word: ");
        word = scanner.nextLine();

        System.out.println(word.substring((word.length()/2), (word.length()/2)+1));
    }
    public static void Ex29() {
        // No package called galapagos, omitting a few exercises
    }
    public static void Ex30() {

    }
    public static void Ex31() {

    }
    public static void Ex32() {

    }
    public static void Ex33() {

    }
}
