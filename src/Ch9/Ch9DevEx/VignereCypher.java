/*
Another encryption technique is called a Vignere cipher. This technique is
similar to a Caesar cipher in that a key is applied cyclically to the original
message. For this exercise a key is composed of uppercase letters only.
Encryption is done by adding the code values of the key’s characters to the
code values of the characters in the original message. Code values for the
key characters are assigned as follows: 0 for A, 1 for B, 2 for C, . . . , and
25 for Z. Let’s say the key is COFFEE and the original message is I drink
only decaf. Encryption works as follows:
I d r i n k o n l y d e c a f
| | | | |
+ + + + . . . +
| | | | |
C O F F E E C O F F E E C O F F E E
K – i W . . . j
Decryption reverses the process to generate the original message. Write an
application that reads in a text and displays the encrypted text. Make sure the
ASCII value resulting from encryption or decryption falls between 32 and
126. You can get the code for key characters by (int) keyChar - 65.
Write another application that reads the encrypted text and displays the
original text, using the Vignere cipher technique.
*/


package Ch9.Ch9DevEx;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VignereCypher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;
        Cipher cipher;
        String text, cipheredText, decipheredText;
        String key;

        while (true) {
            try {
                System.out.print("Enter a cipher key: ");
                key = scanner.nextLine();
                cipher = new Cipher(key);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Cipher key must be a string.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter text: ");
                text = scanner.nextLine();
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        cipheredText = cipher.cipher(text);
        decipheredText = cipher.decipher(cipheredText);

        System.out.println();
        System.out.println("Shift value: " + key);
        System.out.println("Given text: " + text);
        System.out.println("Ciphered text: " + cipheredText);
        System.out.println("Deciphered text: " + decipheredText);
    }
}

