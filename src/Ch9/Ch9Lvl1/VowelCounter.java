package Ch9.Ch9Lvl1;

import java.util.Scanner;

public class VowelCounter {
    /*
     * Write a program that reads in a sentence and displays the count of
     * individual vowels in the sentence. Use any output routine of your
     * choice to display the result in this format. Count only the lowercase
     * vowels. Repeat the operation until an empty string is entered.
     *
     * Vowel counts for the sentence:
     * Mary had a little lamb.
     * # of 'a' : 4
     * # of 'e' : 1
     * # of 'i' : 1
     * # of 'o' : 0
     * # of 'u' : 0
     */

    // data members
    Scanner scanner;
    int a, e, o, u, i;

    // constructors
    public VowelCounter() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        VowelCounter vowelCounter = new VowelCounter();
        vowelCounter.start();
    }

    // start the program loop
    public void start() {
        String str;
        a = 0;
        e = 0;
        o = 0;
        u = 0;
        i = 0;

        while (true) {
            str = getInput();

            if (str.equals("")) {
                break;
            }

            count(str);

            System.out.println("Vowel counts for the sentence");
            System.out.format("%10s%s", " ", str);
            System.out.println();
            System.out.format("# of 'a' : %5d", a);
            System.out.println();
            System.out.format("# of 'e' : %5d", e);
            System.out.println();
            System.out.format("# of 'i' : %5d", i);
            System.out.println();
            System.out.format("# of 'o' : %5d", o);
            System.out.println();
            System.out.format("# of 'u' : %5d", u);
            System.out.println("\n");
        }
    }

    // count the vowels and update the values for a given string
    private void count(String str) {
        int strLength;
        char letter;

        strLength = str.length();

        for (int i = 0; i < strLength; i++) {
            letter = str.charAt(i);
            if (letter == 'a') {
                a++;
            } else if (letter == 'e') {
                e++;
            } else if (letter == 'o') {
                o++;
            } else if (letter == 'u') {
                u++;
            } else if (letter == 'i') {
                i++;
            }
        }
    }

    // get input from the user
    private String getInput() {
        String str;

        System.out.println("Enter a sentence:");
        str = scanner.nextLine();

        return str;
    }
}
