package Ch9;

import java.util.Scanner;

public class ReverseDNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna;
        StringBuilder result;

        while (true) {
            System.out.print("Next DNA sequence: ");
            dna = scanner.nextLine();

            if (dna.equalsIgnoreCase("STOP")) {
                break;
            }

            result = new StringBuilder(dna);
            result.reverse();

            System.out.print("Reversed DNA: " + result.toString());
            System.out.println();
        }
    }
}
