package Ch12.Ch12Lvl3;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlackOut {
    public static void main(String[] args) throws IOException {
        // get the word to black out
        System.out.println("Getting the word...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word to black out: ");
        String word = scanner.nextLine();

        // set up the pattern in accordance with the word
        System.out.println("Compiling pattern...");
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        // select the file
        System.out.println("Showing file dialog...");
        JFileChooser fileChooser = new JFileChooser("files");
        int status = fileChooser.showDialog(null, "Get the document!");

        if (status == JFileChooser.APPROVE_OPTION) {
            // get the file and set up the streams to read the document
            File file = fileChooser.getSelectedFile();
            FileReader fileReader = new FileReader(file);
            Scanner scannerDocument = new Scanner(fileReader);

            // construct the document
            StringBuilder documentBuilder = new StringBuilder();
            String document;
            while (scannerDocument.hasNextLine()) {
                documentBuilder.append(scannerDocument.nextLine());
            }

            // close the stream
            scannerDocument.close();

            // stringify the document
            document = documentBuilder.toString();

            String documentBlackOut = document.replaceAll("(?i)" + word, "<BLACKED OUT>");

            int outStatus = fileChooser.showDialog(null, "Write to document!");

            if (outStatus == JFileChooser.APPROVE_OPTION) {
                // get the file and set up the streams to write the document
                File outFile = fileChooser.getSelectedFile();
                FileOutputStream outputStream = new FileOutputStream(outFile);
                PrintWriter printWriter = new PrintWriter(outputStream);

                printWriter.write(documentBlackOut);

                printWriter.close();
            }
        }
    }
}
