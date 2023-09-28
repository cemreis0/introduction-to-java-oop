/*
Write a code fragment to store and read the contents of the payScaleTable
two-dimensional array from Section 10.5 in the following two file formats:
    • A file of double values
    • A file of two-dimensional array (this is done in the class)
*/

package Ch12.ReviewExercises;

import java.io.*;
import java.util.Arrays;

public class SavePayScaleTableVer2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double[][] payScaleTable = {
            {10.50, 12.00, 14.50, 16.75, 18.00},
            {20.50, 22.25, 24.00, 26.25, 28.00},
            {34.00, 36.50, 38.00, 40.35, 43.00},
            {50.00, 60.00, 70.00, 80.00, 99.99}
        };

        // set up the output streams
        File outFile = new File("files/payscaleobject.dat");
        FileOutputStream outputStream = new FileOutputStream(outFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // save the two-dimensional array as an object
        objectOutputStream.writeObject(payScaleTable);

        // close the stream
        objectOutputStream.close();

        // read the data
        // set up the streams
        File inFile = new File("files/payscaleobject.dat");
        FileInputStream inputStream = new FileInputStream(inFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        // read the object from the file
        double[][] payScaleTableRead;
        payScaleTableRead  = (double[][])  objectInputStream.readObject();
        System.out.println(Arrays.deepToString(payScaleTableRead));


        // close the stream
        objectOutputStream.close();
    }
}
