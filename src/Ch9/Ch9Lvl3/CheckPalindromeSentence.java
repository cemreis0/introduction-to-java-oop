package Ch9.Ch9Lvl3;

import java.util.Scanner;

public class CheckPalindromeSentence {
    public static void main(String[] args) {
        final String CHARS_TO_REMOVE = "[.,;:!?-_(){}/*+ ]";
        Scanner scanner = new Scanner(System.in);
        String sentence;
        boolean isPalindrome = true;

        while (true) {
            System.out.print("Enter a sentence: ");
            sentence = scanner.nextLine();
            sentence = sentence.toLowerCase();

            if (sentence.equalsIgnoreCase("")) {
                break;
            }

            sentence = sentence.replaceAll(CHARS_TO_REMOVE, "");
            sentence = sentence.toLowerCase();
            System.out.println(sentence);

            for (int i = 0; i <= sentence.length() / 2; i++) {
                if (sentence.charAt(i) != sentence.charAt(sentence.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.print("Is the sentence '" + sentence + "' palindrome: " + isPalindrome);
            System.out.println();
        }
    }
}
