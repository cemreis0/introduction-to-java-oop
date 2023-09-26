/*
    Chapter 12 Sample Program: Illustrate how to filter only Java source files for listing in JFileChooser
*/

package Ch12.SampleDevelopment;

import java.io.File;
import javax.swing.filechooser.*;

public class JavaFilter extends FileFilter {
    // data members
    private static final String JAVA = "java";
    private static final char DOT = '.';

    // accepts only directories and files with .java extension only
    public boolean accept(File f) {
        if (f.isDirectory()) {
             return true;
        }
        if (extension(f).equalsIgnoreCase(JAVA)) {
            return true;
        } else {
            return false;
        }
    }

    //description of the filtered files
    public String getDescription( ) {
        return "Java source files (.java)";
    }

    //extracts the extension from the filename
    private String extension(File f) {
        String fileName = f.getName();
        int location = fileName.lastIndexOf(DOT);

        if (location > 0 && location < fileName.length() - 1) {
            // make sure the dot is not at the first or the last character position
            return fileName.substring(location+1);
        } else {
            return "";
        }
    }
}
