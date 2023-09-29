package Ch12.Ch12Lvl2;

import java.io.*;
import java.util.Scanner;
import Ch9.Ch9DevEx.Cipher;

import javax.swing.*;

public class VignereCipherVer2 {
    public static void main(String[] args) throws IOException {
        // cipher operations variables
        Cipher cipher;
        StringBuilder textBuilder = new StringBuilder();
        String text, cipheredText, decipheredText;
        String key = "vignerecipherkey";

        // file selection
        JFileChooser fileChooser = new JFileChooser("files");
        int status = fileChooser.showDialog(null, "Vignere Cipher!");

        // declare the streams
        File file;
        FileReader fileReader;
        Scanner readScanner;

        if (status == JFileChooser.APPROVE_OPTION) {
            // create the streams
            file = fileChooser.getSelectedFile();
            fileReader = new FileReader(file);
            readScanner = new Scanner(fileReader);

            while (readScanner.hasNextLine()) {
                textBuilder.append(readScanner.nextLine());
            }

            // data reading is over
            readScanner.close();

            text = textBuilder.toString();

            cipher = new Cipher(key);

            cipheredText = cipher.cipher(text);
            decipheredText = cipher.decipher(cipheredText);

            System.out.println();
            System.out.println("Shift value: " + key);
            System.out.println("Given text: " + text);
            System.out.println("Ciphered text: " + cipheredText);
            System.out.println("Deciphered text: " + decipheredText);

            // save ciphered text
            status = fileChooser.showDialog(null, "Save Ciphered Text!");
            if (status == JFileChooser.APPROVE_OPTION) {
                // set up the streams
                File saveFile = fileChooser.getSelectedFile();
                FileWriter fileWriter = new FileWriter(saveFile);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.println(cipheredText);

                // data writing is over
                printWriter.close();
            }
        }
    }
}
