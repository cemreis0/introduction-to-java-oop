package Ch12.SampleDevelopment;

import java.io.*;

public class Ch12TestObjectOutputStream {
    public static void main(String[] args) throws IOException {
        // To write objects to a file, we use ObjectOutputStream; and to read objects from a file, we use ObjectInputStream

        // set up the streams
        File outFile = new File("files/objects.dat");
        FileOutputStream outStream = new FileOutputStream(outFile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outStream);

        Person person = new Person("cem", "cem@cem.com");

        outObjectStream.writeObject(person);

        // output done, so close the stream
        outObjectStream.close();
    }
}

