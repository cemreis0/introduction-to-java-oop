/*
THIS IS SLACK JOB

Write an application that removes extra spaces from a text file. In the days of
the typewriter, it was common practice to leave two spaces after periods. We
should not be doing that anymore with the computer, but many people still do.
Read an original text file and output an edited version to another text file. The
edited version should replace two or more consecutive spaces with one space.
*/

package Ch12.Ch12DevEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileSpaceRemover {
    public static String removeExtraSpaces(String input) {
        return input.replaceAll("\\s+", " ");
    }

    public static void processFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String editedLine = removeExtraSpaces(line);
                writer.write(editedLine);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "files/input.txt"; // Replace with your input file path
        String outputFile = "files/output.txt"; // Replace with your output file path

        try {
            processFile(inputFile, outputFile);
            System.out.println("Extra spaces removed and saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
