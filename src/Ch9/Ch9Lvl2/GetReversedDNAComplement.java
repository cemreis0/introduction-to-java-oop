package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class GetReversedDNAComplement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna;
        StringBuilder result;
        StringBuilder reversedResult;
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

            reversedResult = new StringBuilder();

            for (int i = dnaLength-1; i >= 0; i--) {
                reversedResult.append(result.charAt(i));
            }

            System.out.print("DNA Complement: " + reversedResult);
            System.out.println();
        }
    }
}
