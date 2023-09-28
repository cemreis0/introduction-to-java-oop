import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStream {
    public static void main(String[] args) throws IOException {
        /*
        To actually read data from or write data to a file, we must create one of
        the Java stream objects and attach it to the file. A stream is simply a sequence of
        data items, usually 8 bits per item. Java has two types of streams: an input stream
        and an output stream. An input stream has a source from which the data items
        come, and an output stream has a destination to which the data items go. To read
        data items from a file, we attach one of the Java input stream objects to the file.
        Similarly, to write data items to a file, we attach one of the Java output stream
        objects to the file.
         */

        /*
        Java comes with a large number of stream objects for file access operations.
        We will cover only those that are straightforward and easy to learn for beginners.
        We will study two of them in this section—FileOutputStream and FileInputStream.
        These two objects provide low-level file access operations.
        */

        // Let’s first study how to write data values to a file by using FileOutputStream.
        // Using a FileOutputStream object, we can output only a sequence of bytes, that is,
        // values of data type byte. In this example, we will output an array of bytes to a file
        // named sample1.txt. First we create a File object:
        File outFile = new File("sample1.txt");
        byte[] byteArray = {10, 20, 30, 40, 50, 60, 70, 80};
        FileOutputStream outputStream = new FileOutputStream(outFile);
        // We write the whole byte array at once to the file by executing
        outputStream.write(byteArray);

        // It is also possible to write array elements individually, for example
        // output the first and fifth bytes
        outputStream.write(byteArray[0]);
        outputStream.write(byteArray[4]);

        // close the stream
        outputStream.close();

        /*
        To read the data into a program, we reverse the steps in the output routine.
        We use the read method of FileInputStream to read in an array of bytes. First we
        create a FileInputStream object:
        */
        File inFile = new File("sample1.txt");
        FileInputStream fileInputStream = new FileInputStream(inFile);

        int fileSize = (int) inFile.length();
        byte[] byteArray2 = new byte[fileSize];

        fileInputStream.read(byteArray2);
    }
}
