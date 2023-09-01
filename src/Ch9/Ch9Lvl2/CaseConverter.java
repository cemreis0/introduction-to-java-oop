/**
 * Write a program that transposes words in a given sentence. For example,
 * given an input sentence:
 * The gate to Java nirvana is near
 * the method outputs:
 * ehT etag ot avaJ anavrin si raen
 * Repeat the operation until an empty string is entered. To simplify the
 * problem, you may assume the input sentence contains no punctuation marks.
 * You may also assume that the input sentence starts with a nonblank character
 * and that there is exactly one blank space between the words.
 */


package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class CaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence;
        StringBuilder result;
        int sentenceLength;
        char letter;

        while (true) {
            System.out.print("Enter text: ");
            sentence = scanner.nextLine();
            sentenceLength = sentence.length();

            if (sentence.equalsIgnoreCase("")) {
                break;
            }

            result = new StringBuilder();

            for (int i = 0; i < sentenceLength; i++) {
                letter = sentence.charAt(i);

                if (Character.isUpperCase(letter)) {
                    result.append(Character.toLowerCase(letter));
                } else if (Character.isLowerCase(letter)) {
                    result.append(Character.toUpperCase(letter));
                } else {
                    result.append(letter);
                }
            }

            System.out.print("The text with converted cases: " + result);
            System.out.println();
        }
    }
}
