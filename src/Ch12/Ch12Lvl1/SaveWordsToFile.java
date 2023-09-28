/*
Write a program that inputs words from the user and save the entered words,
one word per line, in a text file. The program terminates when the user enters
the word STOP (case-insensitive).
*/

package Ch12.Ch12Lvl1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveWordsToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word;

        // create the file instance to write
        File outFile = new File("files/words.txt");

        // open the stream and start the writing process
        try (PrintWriter printWriter = new PrintWriter(outFile)) {
            while (true) {
                System.out.print("Enter word (STOP to stop): ");
                word = scanner.nextLine();

                if (word.equals("STOP")) {
                    break;
                }

                // write the word
                printWriter.write(word);
                printWriter.write(System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // read the data
        // create the file instance to read from, use scanner to read from the file
        File inFile = new File("files/words.txt");
        Scanner readScanner = new Scanner(inFile);
        String wordRead, longest, shortest;
        int numberOfLetters = 0, count = 0;

        // get the first word before the loop
        wordRead = readScanner.nextLine();
        // set the longest and the shortest words to the first word
        longest = shortest = wordRead;

        /*
        Write a program that reads the words from the text file created by the program of Exercise 6.
        After the file content is read, display the shortest word,
        the longest word, and the average length of the words.
        */

        while (readScanner.hasNextLine()) {
            numberOfLetters += wordRead.length();
            count++;

            // start by printing the word first
            System.out.println(wordRead);

            wordRead = readScanner.nextLine();

            if (wordRead.length() < shortest.length()) {
                shortest = wordRead;
            }

            if (wordRead.length() > longest.length()) {
                longest = wordRead;
            }
        }

        // print the last word
        System.out.println(wordRead);

        // close the scanner
        readScanner.close();

        System.out.println("Longest word: " + longest);
        System.out.println("Shortest word: " + shortest);
        System.out.println("Average length of the words: " + (double) (numberOfLetters/count));
    }
}