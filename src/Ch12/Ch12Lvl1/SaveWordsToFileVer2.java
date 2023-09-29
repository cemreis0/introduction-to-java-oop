/*
Repeat Exercise 6, but this time use an ArrayList of strings. Add all the words
to the ArrayList and save the whole data as a single ArrayList object to an
object file.
*/

package Ch12.Ch12Lvl1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveWordsToFileVer2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        String word;

        // until the user enters STOP keep adding words to the array list
        while (true) {
            System.out.print("Enter word (STOP to stop): ");
            word = scanner.nextLine();

            if (word.equals("STOP")) {
                break;
            }

            words.add(word);
        }

        System.out.println(words);

        /*
        Repeat Exercise 7, but this time read the data from the object file created by
        the program of Exercise 8.
        */

        // set up the streams
        File outFile = new File("files/wordsver2.txt");
        FileOutputStream outputStream = new FileOutputStream(outFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // write the object to the file
        objectOutputStream.writeObject(words);

        // read the file now
        // set up the streams
        File inFile = new File("files/wordsver2.txt");
        FileInputStream inputStream = new FileInputStream(inFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        System.out.println(objectInputStream.readObject());
    }
}
