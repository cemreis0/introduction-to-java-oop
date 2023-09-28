package Ch12.ReviewExercises;

import javax.swing.*;
import java.io.File;

public class DisplayDirectory {
    public static void main(String[] args) {
        // Using a File object, write a code fragment to display files in a user-specified
        // directory.

        JFileChooser fileChooser = new JFileChooser();
        File directory;
        String[] fileName;
        int status;

        // select directories only
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // let user choose a file or a directory
        status = fileChooser.showDialog(null, "Select");


        // if the user uses select button, proceed
        if (status == JFileChooser.APPROVE_OPTION) {
            directory = fileChooser.getSelectedFile();
            // if the selection is a directory list it
            if (directory.isDirectory()) {
                fileName = directory.list();
                for (String name : fileName) {
                    System.out.println(name);
                }
            } else {
                System.out.println("Selected item is not a directory.");
            }
        }
    }
}
