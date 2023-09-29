package Ch9.Ch9DevEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cipher {
    // data members
    private static String key;
    private final static String VALID_KEY_IDENTIFIER = "[A-Z]{1,}";
    private static Pattern keyPattern;
    private static Matcher keyMatcher;

    // constructors
    public Cipher(String cipherKey) {
        keyPattern = Pattern.compile(VALID_KEY_IDENTIFIER);
        setCipherKey(cipherKey);
    }

    public static void setCipherKey(String cipherKey) throws IllegalArgumentException {
        cipherKey = cipherKey.toUpperCase();
        keyMatcher = keyPattern.matcher(cipherKey);

        if (!keyMatcher.matches()) {
            if (cipherKey.isEmpty()) {
                throw new IllegalArgumentException("Cipher key must not be empty.");
            }
            throw new IllegalArgumentException("Cipher key is invalid.");
        }

        key = cipherKey;
    }

    public String cipher(String text) throws IllegalArgumentException {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text must not be null.");
        }

        StringBuilder cipheredText = new StringBuilder();
        char letter;
        int n; // the shift factor obtained from the cipher key

        for (int i = 0; i < text.length(); i++) {
            n = key.charAt(i % key.length()) - 65;
            letter = text.charAt(i);
            letter = (char) ((letter + n - 32) % 95 + 32);
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
        int n; // the shift factor obtained from the cipher key

        for (int i = 0; i < text.length(); i++) {
            n = key.charAt(i % key.length()) - 65;
            letter = text.charAt(i);
            letter = (char) ((letter - n - 32 + 95) % 95 + 32);
            decipheredText.append(letter);
        }

        return decipheredText.toString();
    }
}
