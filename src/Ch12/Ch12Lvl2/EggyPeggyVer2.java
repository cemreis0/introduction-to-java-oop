/**
 Write a program that reads a text file and converts its content to an Eggy-Peggy text (see Exercise 25 of Chapter 9).
 Save the converted text to another
 text file. Use JFileChooser to let the user specify the input and output files.
 Create the input file by using a text editor.
 */

package Ch12.Ch12Lvl2;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EggyPeggyVer2 {
    public static void main(String[] args) throws IOException {
        // declare the streams
        File file;
        FileReader fileReader;
        Scanner readScanner;

        // file selection
        JFileChooser fileChooser = new JFileChooser("files");
        int status = fileChooser.showDialog(null, "Eggy Peggy!");

        // eggypeggy operation variables
        final String VOWELS = "[aeouiAEOUI]";
        String str, letter;
        StringBuilder result;
        int strSize;

        // proceed getting the file if the status is approved
        if (status == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();

            // create stream instances
            fileReader = new FileReader(file);
            readScanner = new Scanner(fileReader);

            result = new StringBuilder();

            while (readScanner.hasNextLine()) {
                str = readScanner.nextLine();

                strSize = str.length();

                for (int i = 0; i < strSize; i++) {
                    letter = Character.toString(str.charAt(i));

                    if (letter.matches(VOWELS)) {
                        result.append("egg");
                    }

                    result.append(str.charAt(i));
                }

                result.append(" ");
            }
            System.out.println("Eggy result: " + result);
        }
    }
}
