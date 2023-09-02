package Ch9.Ch9Lvl3;

import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        final char BLANK = ' ';
        Scanner scanner = new Scanner(System.in);
        int index, wordCount, numberOfCharacters;

        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();
        sentence = sentence.trim(); // remove leading and trailing white spaces

        numberOfCharacters = sentence.length();

        index = 0;
        wordCount = 0;

        while (index < numberOfCharacters) {
            //ignore blank spaces
            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;
            }

            //now locate the end of the word
            while (index < numberOfCharacters && sentence.charAt(index) != BLANK) {
                index++;
            }

            // another word is found, so increment the counter
            wordCount++;
        }

        //display the result
        System.out.println("\ninput sentence: " + sentence );
        System.out.println("Word count: " + wordCount + " words" );
    }
}
