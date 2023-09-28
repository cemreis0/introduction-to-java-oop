/*
    Chapter 12 Sample Program: A test program to load data from a file using DataInputStream for high-level I/O.
*/

package Ch12.SampleDevelopment;

import java.io.*;

public class Ch12TestDataInputStream {
    public static void main(String[] args) throws IOException {
        //set up file and stream
        File inFile = new File("C:\\Users\\cemmr\\Code\\java\\introduction-to-java-oop\\src\\Ch12\\SampleDevelopment\\sample2.txt");
        FileInputStream inFileStream = new FileInputStream(inFile);
        DataInputStream inDataStream = new DataInputStream(inFileStream);

        //read values back from the stream and display them
        System.out.println(inDataStream.readInt());
        System.out.println(inDataStream.readLong());
        System.out.println(inDataStream.readFloat());
        System.out.println(inDataStream.readDouble());
        System.out.println(inDataStream.readChar());
        System.out.println(inDataStream.readBoolean());

        //input done, so close the stream
        inDataStream.close();
    }
}
