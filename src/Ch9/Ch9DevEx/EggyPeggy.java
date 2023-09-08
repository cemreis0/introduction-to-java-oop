/**
 * Write an Eggy-Peggy program. Given a string, convert it to a new string by
 * placing egg in front of every vowel. For example, the string
 * I Love Java
 * becomes
 * eggI Leegoveege Jeegaveega
 */

package Ch9.Ch9DevEx;

import java.util.Scanner;

public class EggyPeggy {
    public static void main(String[] args) {
        final String VOWELS = "[aeouiAEOUI]";
        Scanner scanner = new Scanner(System.in);
        String str, letter;
        StringBuilder result;
        int strSize;

        while (true) {
            System.out.println("Enter text:");
            str = scanner.nextLine();

            strSize = str.length();

            if (str.equals("")) break;

            result = new StringBuilder();

            for (int i = 0; i < strSize; i++) {
                letter = Character.toString(str.charAt(i));

                if (letter.matches(VOWELS)) {
                    result.append("egg");
                }

                result.append(str.charAt(i));
            }

            System.out.println("Eggy result: " + result);
        }
    }
}
