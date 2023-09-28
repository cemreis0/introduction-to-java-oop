/*
Write a code fragment to store and read the contents of the payScaleTable
two-dimensional array from Section 10.5 in the following two file formats:
    • A file of double values (this is done in the class)
    • A file of two-dimensional array
*/

package Ch12.ReviewExercises;

import java.io.*;

public class SavePayScaleTable {
    public static void main(String[] args) throws IOException {
        double[][] payScaleTable = {
            {10.50, 12.00, 14.50, 16.75, 18.00},
            {20.50, 22.25, 24.00, 26.25, 28.00},
            {34.00, 36.50, 38.00, 40.35, 43.00},
            {50.00, 60.00, 70.00, 80.00, 99.99}
        };

        // set up the output streams
        File outFile = new File("files/payscale.dat");
        FileOutputStream outputStream = new FileOutputStream(outFile);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // for each element in the array, write to file
        for (int i = 0; i < payScaleTable.length; i++) {
            for (int j = 0; j < payScaleTable[i].length; j++) {
                dataOutputStream.writeDouble(payScaleTable[i][j]);
            }
        }

        //output done, so close the stream
        dataOutputStream.close();

        // read data from the file
        // set up the streams
        File inFile = new File("files/payscale.dat");
        FileInputStream inputStream = new FileInputStream(inFile);
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // as long as the stream is available keep reading and displaying double values
        System.out.println(dataInputStream.readDouble());
        while (dataInputStream.available() > 0) {
            System.out.println(dataInputStream.readDouble());
        }

        //input done, so close the stream
        dataInputStream.close();
    }
}
