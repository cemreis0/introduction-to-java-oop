import java.util.Scanner;

public class StringBufferClass {
    public static void main(String[] args) {
        StringBuffer word = new StringBuffer("Java");
        word.setCharAt(0, 'D');
        word.setCharAt(1, 'i');
        System.out.println(word);

        // Replace every vowel in a given sentence with 'X' using StringBuffer.
        // replaceVowels();

        // Constructs a new sentence from input words that have an even number of letters.
        // evenLetterWords();

        qc2();
    }

    public static void replaceVowels() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder tempStringBuilder;
        String inSentence;
        int numberOfCharacters;
        char letter;

        System.out.println("Sentence:");
        inSentence = scanner.nextLine();

        tempStringBuilder = new StringBuilder(inSentence);
        numberOfCharacters = tempStringBuilder.length();

        for (int i = 0; i < numberOfCharacters; i++) {
            letter = tempStringBuilder.charAt(i);
            if (letter == 'a' || letter == 'A' ||
                letter == 'e' || letter == 'E' ||
                letter == 'i' || letter == 'I' ||
                letter == 'o' || letter == 'O' ||
                letter == 'u' || letter == 'U' ) {
                tempStringBuilder.setCharAt(i,'X');
            }
        }

        System.out.println("Input: " + inSentence);
        System.out.println("Output: " + tempStringBuilder);
    }

    public static void evenLetterWords() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder tempStringBuilder;
        String word;

        tempStringBuilder = new StringBuilder();

        while (true) {
            System.out.print("Next word: ");
            word = scanner.next( );

            if (word.equals("STOP")) break;

            if (word.length() % 2 == 0) tempStringBuilder.append(word + " ");
        }

        System.out.println("Output: " + tempStringBuilder);
    }

    public static void qc2() {
        // Assume a String object str is assigned as a string value. Write a code segment
        // to replace all occurrences of lowercase vowels in a given string to the letter C
        // by using String and StringBuffer objects.

        String sentence = "LOrem ipsum dolOr sit Amet.";
        StringBuilder tempStringBuilder;
        int numberOfCharacters;
        char letter;

        tempStringBuilder = new StringBuilder(sentence);
        numberOfCharacters = tempStringBuilder.length();

        for (int i = 0; i < numberOfCharacters; i++) {
            letter = tempStringBuilder.charAt(i);
            if (letter == 'a'|| letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ) {
                tempStringBuilder.setCharAt(i,'C');
            }
        }

        System.out.println(tempStringBuilder);
    }
}
