package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        boolean isPalindrome = true;

        while (true) {
            System.out.print("Enter a word: ");
            word = scanner.nextLine();
            word = word.toLowerCase();

            if (word.equalsIgnoreCase("")) {
                break;
            }

            for (int i = 0; i <= word.length()/2; i++) {
                if (word.charAt(i) != word.charAt(word.length()-1-i)) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.print("Is the word '" + word + "' palindrome: " + isPalindrome);
            System.out.println();
        }
    }
}
