/*
Write a program that input N words (string) and output them in alphabetical
order. Use the sorting algorithm from Exercise 6 or Exercise 7.
*/

package Ch11.Ch11Lvl1;

import java.util.Scanner;

public class LexicographicOrder {
    public static void main(String[] args) {
        BubbleSortString bubbleSortString = new BubbleSortString();
        Scanner scanner = new Scanner(System.in);
        String response;
        String[] words;
        int numberOfWords;

        System.out.print("How many words? ");
        numberOfWords = scanner.nextInt();

        words = new String[numberOfWords];

        for (int i = 0; i < numberOfWords; i++) {
            System.out.print("Enter word (STOP to stop): ");
            response = scanner.next();

            if (response.equals("STOP")) {
                break;
            }

            words[i] = response;
        }

        words = bubbleSortString.sort(words);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
