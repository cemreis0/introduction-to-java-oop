import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileInputAndOutput {
    public static void main(String[] args) {
        // Before we can start reading data from a file, we must first create a File object
        File inFile = new File("sample.data");

        // It is also possible to open a file that is stored in a directory other than the
        // current directory by providing a path name and a filename. Assuming there’s a file
        // xyz.data in the JavaPrograms directory, we can open it by executing
        File inFile1 = new File("C:\\JavaProgram", "xyz.data");

        // We can check if a File object is associated correctly to an existing file by calling its exists method:
        if (inFile1.exists()) {
            // inFile is associated correctly to an existing file
        } else {
            // inFile is not associated correctly to any existing file
        }

        // A File object can also be associated to a directory. For example, suppose we
        // are interested in listing the content of directory Ch12. We can first create a File object
        // and associate it to the directory. After the association is made, we can list the contents of
        // the directory by calling the object’s list method:
        File directory = new File("C:/Users/cemmr/Code/java/introduction-to-java-oop/src");
        String[] fileName = directory.list();
        for (int i = 0; i < fileName.length; i++) {
            System.out.println(fileName[i]);
        }

        // We check whether a File object is associated to a file or a directory by calling
        // its boolean method isFile.
        File file = new File("C:/Users/cemmr/Code/java/introduction-to-java-oop/src/Ch12");
        System.out.print("Ch12 says: ");
        if (file.isFile()) {
            System.out.println("I am a file.");
        } else {
            System.out.println("I am a directory.");
        }

        // We can use a javax.swing.JFileChooser object to let the user select a file.
        JFileChooser fileChooser = new JFileChooser("C:/Users/cemmr/Code/java/introduction-to-java-oop/src/");
        fileChooser.showOpenDialog(null);

        // Instead of designating a fixed directory as in this example, we may wish to
        // begin the listing from the current directory. Since the current directory is different
        // when the program is executed from a different directory, we need a general approach.
        String current = System.getProperty("user.dir");
        JFileChooser fileChooser1 = new JFileChooser(new File(current)); // or the argument is directly "current"
        fileChooser1.showOpenDialog(null);

        // To check whether the user has clicked on the Open or Cancel button, we test
        // the return value from the showOpenDialog method.
        int status = fileChooser1.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            System.out.println("Open is clicked.");
        } else { // JFileChooser.CANCEL_OPTION
            System.out.println("Cancel is clicked.");
        }

        // Once we determine the Open button is clicked, we can retrieve the selected file as
        File selectedFile;
        selectedFile = fileChooser1.getSelectedFile();
        File currentDirectory;
        currentDirectory = fileChooser1.getCurrentDirectory();

        System.out.println("File name: " + selectedFile.getName() + " Absolute path: " + selectedFile.getAbsolutePath());

        // To display a JFileChooser with the Save button, we write
        fileChooser1.showSaveDialog(null);

        // Using the showDialog method, we can specify the button
        // label and the dialog title. For example, this code will produce a JFileChooser dialog
        // with the text Compile as its title and label for the okay button:
        fileChooser1.showDialog(null, "Compile");

        // We can use a file filter to remove unwanted files from the list.
        boolean accept(File file);
        String getDescription;
    }
}
