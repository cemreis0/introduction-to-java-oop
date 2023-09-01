/**
 * A codon is a triplet of nucleotides that specifies a single amino acid
 * (a protein is a sequence of amino acids). Write a program that outputs
 * codons given a DNA (or RNA) sequence. For example, if the input is
 * GATTCGATC, the program outputs GAT, TCG, and ATC. Output one
 * codon per line. If the length of an input string is not a multiple of 3, then
 * ignore any leftover nucleotides. For example, if the input is GATTCGA,
 * then output will be GAT and TCG. Repeat the operation until an empty
 * string is entered.
 */


package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class GetCodons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna;
        String codon;
        StringBuilder result;
        int dnaLength;
        int numberOfCodons;

        while (true) {
            System.out.print("Next DNA sequence: ");
            dna = scanner.nextLine();

            dnaLength = dna.length();
            numberOfCodons = dnaLength / 3;

            if (dna.equalsIgnoreCase("")) {
                break;
            }

            result = new StringBuilder();

            int index = 0;
            for (int i = 0; i < numberOfCodons; i++) {
                codon = dna.substring(index, index+3);
                result.append(codon);
                result.append(" ");

                index += 3;
            }

            System.out.print("Codons: " + result);
            System.out.println();
        }
    }
}
