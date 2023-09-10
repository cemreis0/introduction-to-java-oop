/*
A public-key cryptography allows anyone to encode messages while only
people with a secret key can decipher them. In 1977, Ronald Rivest, Adi
Shamir, and Leonard Adleman developed a form of public-key cryptography
called the RSA system.
To encode a message using the RSA system, one needs n and e. The
value n is a product of any two prime numbers p and q. The value e is any
number less than n that cannot be evenly divided into y (that is, y  e would
have a remainder), where y  (p  1)  (q  1). The values n and e can be
published in a newspaper or posted on the Internet, so anybody can encrypt
messages. The original character is encoded to a numerical value c by using
the formula
c  me mod n
where m is a numerical representation of the original character (for example,
1 for A, 2 for B, and so forth).
Now, to decode a message, one needs d. The value d is a number that
satisfies the formula
e  d mod y  1
where e and y are the values defined in the encoding step. The original
character m can be derived from the encrypted character c by using the
formula
m  cd mod n
Write a program that encodes and decodes messages using the RSA system.
Use large prime numbers for p and q in computing the value for n, because
when p and q are small, it is not that difficult to find the value of d. When p
and q are very large, however, it becomes practically impossible to
determine the value of d. Use the ASCII values as appropriate for the
numerical representation of characters. Visit http://www.rsasecurity.com for
more information on how the RSA system is applied in the real world.
*/


package Ch9.Ch9DevEx;

import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        RSACipher rsaCipher = new RSACipher();
        Scanner scanner = new Scanner(System.in);
        String text, encryptedText, decryptedText;

        while (true) {
            try {
                System.out.print("Enter text: ");
                text = scanner.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        encryptedText = rsaCipher.encrypt(text);
        decryptedText = rsaCipher.decrypt(encryptedText);

        System.out.println("Given text: " + text);
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + decryptedText);
    }
}

class RSACipher {
    // data members
    private static final BigInteger P = new BigInteger("113"); // prime number
    private static final BigInteger Q = new BigInteger("179"); // prime number
    private static final BigInteger N = P.multiply(Q);
    private static final BigInteger Y = (P.subtract(BigInteger.ONE)).multiply(Q.subtract(BigInteger.ONE));
    private static final BigInteger E = new BigInteger("7919"); // Encryption key (public)
    private static final BigInteger D = calculatePrivateKey(E, Y); // Decryption key (private)
    private StringBuilder encryptedText, decryptedText;

    // constructors
    public RSACipher() {

    }

    public String encrypt(String text) throws IllegalArgumentException {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text must not be empty");
        }

        encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            BigInteger encodedCharacter = BigInteger.valueOf(character).modPow(E, N);
            encryptedText.append(encodedCharacter.toString()).append(" ");
        }

        return encryptedText.toString().trim();
    }

    public String decrypt(String text) throws IllegalArgumentException {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text must not be empty");
        }

        decryptedText = new StringBuilder();
        String[] blocks = text.split(" ");

        for (String block : blocks) {
            BigInteger encodedBlock = new BigInteger(block);
            BigInteger decodedBlock = encodedBlock.modPow(D, N);
            decryptedText.append((char) decodedBlock.intValue());
        }

        return decryptedText.toString();
    }



    private static BigInteger calculatePrivateKey(BigInteger publicKey, BigInteger phiN) {
        return publicKey.modInverse(phiN);
    }
}