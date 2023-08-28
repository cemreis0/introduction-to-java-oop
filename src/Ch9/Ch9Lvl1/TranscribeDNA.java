package Ch9.Ch9Lvl1;

import com.sun.source.tree.PatternTree;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranscribeDNA {
    /**
     * In the CH9TranscribeDNA program, we used the basic string processing
     * approach. Rewrite the program by using the pattern-matching approach. Do
     * not use the replaceAll method of the String class. Because we perform the
     * transcription operation repeatedly, it is more efficient to use the Pattern and
     * Matcher classes directly. Create an appropriate Matcher object before the
     * while loop.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna = "";
        StringBuilder rna;

        Pattern pattern = Pattern.compile("T");
        Matcher matcher;

        while (true) {
            System.out.print("Next DNA Sequence: ");
            dna = scanner.nextLine();

            matcher = pattern.matcher(dna);

            if (dna.equalsIgnoreCase("STOP")) {
                break;
            }

            rna = new StringBuilder(dna);

            while (matcher.find()) {
                rna.replace(matcher.start(), matcher.end(),"U");
            }

            System.out.println("RNA:" + rna.toString());
            System.out.println();
        }
    }
}
