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

                    // another word is found, so increment the counter
                    word = new StringBuilder(sentence.substring(startIndex, endIndex));
                    word.reverse();

                    result.append(word);
                    result.append(" ");
                }
            }

            System.out.print("The text with converted cases: " + result);
            System.out.println();
        }
    }
}

