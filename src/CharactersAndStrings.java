import java.util.Scanner;

public class CharactersAndStrings {
    public static void main(String[] args) {
        char ch1, ch2 = 'X';

        System.out.println("ASCII code of character X"+ " is " + (int)'X');
        System.out.println("Character with ASCII code 88 is " + (char)88);
        System.out.println();
        System.out.println("ASCII code of character a is " + (int)'a');
        System.out.println("Character with ASCII code 97 is " + (char)97);
        System.out.println();
        System.out.println('X' > 'a' ? "X > a" : "X < a");
        System.out.println();

        // count words
        reverse();
    }

    public static void countVowels() {
        Scanner scanner = new Scanner(System.in);
        String name, nameLower;
        int numberOfCharacters, vowelCount = 0;
        char letter;

        System.out.print("What is your name? ");
        name = scanner.next( );

        numberOfCharacters = name.length();
        nameLower = name.toLowerCase();

        for (int i = 0; i < numberOfCharacters; i++) {
            letter = nameLower.charAt(i);
            if (letter == 'a' ||
                letter == 'e' ||
                letter == 'i' ||
                letter == 'o' ||
                letter == 'u' ) {
                vowelCount++;
            }
        }
        System.out.println(name + ", your name has " + vowelCount + " vowels");
    }

    public static void countWords() {
        final char BLANK = ' ';
        Scanner scanner = new Scanner(System.in);
        int index, wordCount, numberOfCharacters;

        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();

        numberOfCharacters = sentence.length();

        index = 0;
        wordCount = 0;

        while (index < numberOfCharacters) {
            //ignore blank spaces
            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;
            }

            // check if there is a word
            if (index < numberOfCharacters) {
                // now locate the end of the word
                while (index < numberOfCharacters && sentence.charAt(index) != BLANK) {
                    index++;
                }

                // another word is found, so increment the counter
                wordCount++;
            }
        }

        //display the result
        System.out.println("\ninput sentence: " + sentence );
        System.out.println("Word count: " + wordCount + " words" );
    }

    public static void countJava() {
        Scanner scanner = new Scanner(System.in);
        int javaCount = 0;
        String word;

        while (true) {
            System.out.print("Next word: ");
            word = scanner.nextLine( );

            if (word.equals("STOP")) {
                break;
            } else if (word.equalsIgnoreCase("Java")){
                javaCount++;
            }
        }
        System.out.println("'Java' count: " + javaCount );
    }

    public static void extractWords() {
        final char BLANK = ' ';
        Scanner scanner = new Scanner(System.in);
        int index, numberOfCharacters, beginIdx, endIdx;
        String word, sentence;

        System.out.print("Input: ");
        sentence = scanner.nextLine();

        numberOfCharacters = sentence.length();
        index = 0;

        while (index < numberOfCharacters) {
            //ignore leading blank spaces
            while (index < numberOfCharacters && sentence.charAt(index) == BLANK) {
                index++;
            }
            beginIdx = index;

            //now locate the end of the word
            while (index < numberOfCharacters && sentence.charAt(index) != BLANK) {
                index++;
            }
            endIdx = index;

            if (beginIdx != endIdx) {
                //another word is found, extract it from the
                //sentence and print it out
                word = sentence.substring( beginIdx, endIdx );
                System.out.println(word);
            }
        }
    }

    public static void reverse() {
        Scanner scanner = new Scanner(System.in);
        String input, reversed = "";
        int numOfChars;

        System.out.println("Enter string:");
        input = scanner.nextLine();

        numOfChars = input.length();

        for (int i = numOfChars-1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
