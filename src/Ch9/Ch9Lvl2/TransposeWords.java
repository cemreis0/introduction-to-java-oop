package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class TransposeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence;
        StringBuilder result;
        int sentenceLength;
        int index;
        int startIndex, endIndex; // location of a word
        StringBuilder word;
        String punctuation; // punctuation mark at the end of a word, if exists
        final String PUNCTUATION_IDENTIFIER = "[!.?,:;]"; // pattern for punctuation marks

        while (true) {
            System.out.print("Enter text: ");
            sentence = scanner.nextLine();
            sentenceLength = sentence.length();

            if (sentence.equalsIgnoreCase("")) {
                break;
            }

            result = new StringBuilder();

            index = 0;
            while (index < sentenceLength) {
                //ignore blank spaces
                while (index < sentenceLength && sentence.charAt(index) == ' ') {
                    index++;
                }
                // check if there is a word
                if (index < sentenceLength) {
                    startIndex = index;
                    // now locate the end of the word
                    while (index < sentenceLength && sentence.charAt(index) != ' ') {
                        index++;
                    }
                    endIndex = index;

                    // assign the character at the end of the word as a punctuation mark, if it's indeed a punctuation mark,
                    // append it at after the word is appended and reversed
                    punctuation = Character.toString(sentence.charAt(index-1));

                    if (punctuation.matches(PUNCTUATION_IDENTIFIER)) {
                        word = new StringBuilder(sentence.substring(startIndex, endIndex-1));
                        word.reverse();
                        word.append(punctuation);
                    } else {
                        word = new StringBuilder(sentence.substring(startIndex, endIndex));
                        word.reverse();
                    }

                    result.append(word);
                    result.append(" ");
                }
            }

            System.out.print("The text with converted cases: " + result);
            System.out.println();
        }
    }
}

