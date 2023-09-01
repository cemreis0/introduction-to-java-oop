/**
 * Finding the complement of a given DNA strand is another common operation.
 * The double helix of DNA is composed of two complementary strands.
 * Because the base pairs are formed by pairing A with T and G with C, we can
 * easily find the complement of a given DNA strand by simple substitutions.
 * For example, the complement of GATTCGATC is CTAAGCTAG.
 * Write a program that outputs the complement of a given DNA strand.
 * Repeat the operation until an empty string is entered.
 */


package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class GetDNAComplement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna;
        StringBuilder result;
        int dnaLength;
        char base;

        while (true) {
            System.out.print("Next DNA sequence: ");
            dna = scanner.nextLine();
            dnaLength = dna.length();

            if (dna.equalsIgnoreCase("")) {
                break;
            }

            result = new StringBuilder(dna);

            for (int i = 0; i < dnaLength; i++) {
                base = dna.charAt(i);
                if (base == 'A') result.replace(i, i+1, "T");
                else if (base == 'T') result.replace(i, i+1, "A");
                else if (base == 'G') result.replace(i, i+1, "C");
                else if (base == 'C') result.replace(i, i+1, "G");
            }

            System.out.print("DNA Complement: " + result);
            System.out.println();
        }
    }
}
