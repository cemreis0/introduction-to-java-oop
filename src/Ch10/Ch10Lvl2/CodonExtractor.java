/**
 * This program extracts codons from an input DNA (or RNA) sequence
 * and stores them in an ArrayList.
 * A codon is a triplet of nucleotides that specifies a single amino acid.
 * A protein is a sequence of amino acids.
 * For example, if the input is "GATTCGATC", the program stores "GAT", "TCG",
 * and "ATC" in an ArrayList. If the length of an input string is not a multiple
 * of 3, then any leftover nucleotides are ignored.
 * Output codons in the list using the for-each loop.
 * Repeat the operation until an empty string is entered.
 */


package Ch10.Ch10Lvl2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodonExtractor {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        Scanner scanner = new Scanner(System.in);
        String input;
        List<String> result;

        while (true) {
            try {
                System.out.println("Enter nucleic acid (N to exit):");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("N")) {
                    break;
                }

                result = extractor.extractCodons(input);

                for (String codon : result) {
                    System.out.println(codon);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Extractor {
    // data members
    private static final String NUCLEIC_ACID_IDENTIFIER = "[ATGC]*";
    private Pattern nucleicAcidPattern;
    private Matcher nucleicAcidMatcher;

    // constructors
    public Extractor() {
        nucleicAcidPattern = Pattern.compile(NUCLEIC_ACID_IDENTIFIER);
    }

    public List<String> extractCodons(String nucleicAcid) throws IllegalArgumentException, IllegalStateException {
        if (nucleicAcid.length() < 3) {
            throw new IllegalStateException("Not enough nucleotides to extract.");
        }

        nucleicAcidMatcher = nucleicAcidPattern.matcher(nucleicAcid);

        if (!nucleicAcidMatcher.matches()) {
            throw new IllegalArgumentException("Nucleic acid is invalid.");
        }

        List<String> codons = new ArrayList<>();
        int nucleicAcidLength = nucleicAcid.length();
        String codon;

        nucleicAcidLength = nucleicAcidLength - (nucleicAcidLength % 3);

        for (int i = 0; i < nucleicAcidLength; i += 3) {
            codon = nucleicAcid.substring(i, i+3);
            codons.add(codon);
        }

        return codons;
    }
}