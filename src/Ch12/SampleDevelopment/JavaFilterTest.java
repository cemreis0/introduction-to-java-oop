package Ch12.SampleDevelopment;

import javax.swing.*;

public class JavaFilterTest {
    public static void main(String[] args) {
        // With the filter class Java Filter in place, we can set a file chooser to list only
        // directories and Java source files
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        fileChooser.setFileFilter(new JavaFilter());
        int status = fileChooser.showOpenDialog(null);
    }
}
