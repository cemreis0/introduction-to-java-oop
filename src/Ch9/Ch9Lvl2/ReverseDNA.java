/**
 * In the Ch9ReverseDNA program, we used the reverse method of the StringBuffer class to reverse a given DNA sequence (see also Exercise 10).
 * Rewrite the Ch9ReverseDNA program without using the reverse method.
 * You have to scan the input string and build a new (reversed) string.
 */


package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class ReverseDNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna;
        StringBuilder result;
        int dnaLength;

        while (true) {
            System.out.print("Next DNA sequence: ");
            dna = scanner.nextLine();
            dnaLength = dna.length();

            if (dna.equalsIgnoreCase("STOP")) {
                break;
            }

            result = new StringBuilder();

            for (int i = dnaLength-1; i >= 0; i--) {
                result.append(dna.charAt(i));
            }

            System.out.print("Reversed DNA: " + result);
            System.out.println();
        }
    }
}

