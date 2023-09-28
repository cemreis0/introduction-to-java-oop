/*
Chapter 12 Sample Program: A test program to save data to a file using DataOutputStream for high-level I/O.
*/

package Ch12.SampleDevelopment;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ch12TestDataOutputStream {
    public static void main(String[] args) throws IOException {
        // set up the streams
        File outFile = new File("C:\\Users\\cemmr\\Code\\java\\introduction-to-java-oop\\src\\Ch12\\SampleDevelopment\\sample2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        //write values of primitive data types to the stream
        dataOutputStream.writeInt(987321);
        dataOutputStream.writeLong(11111L);
        dataOutputStream.writeFloat(22222F);
        dataOutputStream.writeDouble(33333);
        dataOutputStream.writeChar('A');
        dataOutputStream.writeBoolean(true);

        //output done, so close the stream
        dataOutputStream.close();
    }
}
