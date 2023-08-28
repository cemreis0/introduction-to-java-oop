package Ch9;

import java.util.Scanner;

public class GCContent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna;
        int gcCount;
        int size;
        char base;
        double result;

        gcCount = 0;
        size = 0;

        while (true) {
            System.out.print("Next DNA sequence: ");
            dna = scanner.nextLine();

            if (dna.equalsIgnoreCase("STOP") ) {
                break;
            }

            size = dna.length();
            gcCount = 0;

            for (int i = 0; i < size; i++) {
                base = dna.charAt(i);
                if (base == 'G' || base == 'C') {
                    gcCount++;
                }
            }

            result = (double) gcCount / size * 100;

            System.out.println("GC-Content: " + result + "%");
            System.out.println();
        }
    }
}
