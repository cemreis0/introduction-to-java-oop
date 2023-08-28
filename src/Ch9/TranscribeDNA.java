package Ch9;

import java.util.Scanner;

public class TranscribeDNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna;
        StringBuilder rna;
        int size;
        char base;

        while (true) {
            System.out.print("Next DNA Sequence: ");
            dna = scanner.nextLine();

            if (dna.equalsIgnoreCase("STOP")) {
                break;
            }

            size = dna.length();
            rna = new StringBuilder();

            //scan through each letter and replace T with U
            for (int i = 0; i < size; i++) {
                base = dna.charAt(i);

                if (base == 'T') {
                    base = 'U';
                }

                rna.append(base);
            }

            System.out.println("RNA:" + rna.toString());
            System.out.println();
        }
    }
}
