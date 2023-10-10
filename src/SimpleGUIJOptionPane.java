import javax.swing.*;

public class SimpleGUIJOptionPane {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "I love Java.");

        /*
        In a GUI environment, there are basically two types of windows: a general-purpose
        frame and a special-purpose dialog. In Java, we use a JFrame object for
        a frame window and a JDialog object for a dialog.
        */

        /*
        The first argument to the
        showMessageDialog method is a frame object that controls this dialog, and the
        second argument is the text to display. In the example statement, we pass null, a
        reserved word, meaning there is no frame object. If we pass null as the first argument, the dialog appears in the
        center of the screen. If we pass a frame object, then the dialog is positioned at the center of the frame.
        Run the Ch14ShowMessageDialog class and confirm this behavior.
        */

        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setVisible(true);

        JOptionPane.showMessageDialog(jFrame, "How are you?");
        JOptionPane.showMessageDialog(null, "Goodbye.");

        JOptionPane.showMessageDialog(null, "one\ntwo\nthree"); // multiple lines of text

        JOptionPane.showInputDialog(null, "Enter text: "); // input dialog

        // assigning the input to a string
        // input dialog only supports strings, need to parse other data types
        String string;
        string = JOptionPane.showInputDialog(null, "Enter text (your input will be saved): ");

        JOptionPane.showMessageDialog(null, string);

        // QC1:
        // Using JOptionPane input dialog, write a statement to input the person’s first name

        String name;
        name = JOptionPane.showInputDialog(null, "Enter your name:");

        // QC2:
        // Using JOptionPane input dialog, write a statement to input the person’s age (integer).

        String ageString;
        int age;

        ageString = JOptionPane.showInputDialog(null, "Enter your age:");
        age = Integer.parseInt(ageString);
    }
}
