/*
    Chapter 12 Sample Program: A test program to save data to a file using FileOutputStream
*/

package Ch12.SampleDevelopment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ch12TestFileOutputStream {
    public static void main(String[] args) throws IOException {
        //set up file and stream
        File outFile = new File("src/Ch12/SampleDevelopment/sample1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);

        //data to output
        byte[] byteArray = {10, 20, 30, 40, 50, 60, 70, 80};

        //write data to the stream
        fileOutputStream.write(byteArray);

        //output done, so close the stream
        fileOutputStream.close();
    }
}
