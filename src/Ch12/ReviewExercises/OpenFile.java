package Ch12.ReviewExercises;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;

public class OpenFile {
    public static void main(String[] args) {
        // Using the try–catch block, write a code fragment that opens a file default.dat
        // when an attempt to open a user-designated file raises an exception.

        JFileChooser fileChooser = new JFileChooser();
        File selectedFile;

        try {
            fileChooser.showOpenDialog(null);
            selectedFile = fileChooser.getSelectedFile();
        } catch (Exception e) {
            selectedFile = new File("files/default.dat");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        System.out.println(selectedFile);
    }
}
