/**
 * The word game Eggy-Peggy is an example of encryption. Encryption has
 * been used since ancient times to communicate messages secretly. One of the
 * many techniques used for encryption is called a Caesar cipher. With this
 * technique, each character in the original message is shifted N positions. For
 * example, if N is 1, then the message
 *
 * I d r i n k o n l y d e c a f
 *
 * becomes
 *
 * J ! e s j o l ! p o m z ! e f d b g
 *
 * The encrypted message is decrypted to the original message by shifting back
 * every character N positions. Shifting N positions forward and backward is
 * achieved by converting the character to ASCII and adding or subtracting N.
 * Write an application that reads in the original text and the value for N and
 * displays the encrypted text. Make sure the ASCII value resulting from encryption
 * falls between 32 and 126. For example, if you add 8 (value of N) to 122
 * (ASCII code for ‘z’), you should “wrap around” and get 35.
 * Write another application that reads the encrypted text and the value
 * for N and displays the original text by using the Caesar cipher technique.
 * Design a suitable user interface.
 */


package Ch9.Ch9DevEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaesarCypher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;
        Cypher cypher;
        String text, cipheredText, decipheredText;
        int n;

        while (true) {
            try {
                System.out.print("Enter a shift value: ");
                n = scanner.nextInt();
                cypher = new Cypher(n);
                break;
            } catch (InputMismatchException e) {
                System.out.println("N must be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
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

        cipheredText = cypher.cipher(text);
        decipheredText = cypher.decipher(cipheredText);

        System.out.println();
        System.out.println("Shift value: " + n);
        System.out.println("Given text: " + text);
        System.out.println("Ciphered text: " + cipheredText);
        System.out.println("Deciphered text: " + decipheredText);
    }
}

class Cypher {
    // data members
    private static int N; // shift position by N

    // constructors
    public Cypher(int n) {
        setN(n);
    }

    public static void setN(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("N must not be negative.");
        } else if (n == 0) {
            throw new IllegalArgumentException("N must not be zero");
        }
        N = n;
    }

    public String cipher(String text) throws IllegalArgumentException {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text must not be null.");
        }

        StringBuilder cipheredText = new StringBuilder();
        char letter;

        for (int i = 0; i < text.length(); i++) {
            letter = text.charAt(i);
            letter = (char) ((letter + N - 32) % 95 + 32);
            cipheredText.append(letter);
        }

        return cipheredText.toString();
    }

    public String decipher(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text must not be null.");
        }

        StringBuilder decipheredText = new StringBuilder();
        char letter;

        for (int i = 0; i < text.length(); i++) {
            letter = text.charAt(i);
            letter = (char) ((letter - N - 32 + 95) % 95 + 32);
            decipheredText.append(letter);
        }

        return decipheredText.toString();
    }
}