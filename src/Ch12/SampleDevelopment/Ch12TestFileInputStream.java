package Ch12.SampleDevelopment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ch12TestFileInputStream {
    public static void main(String[] args) throws IOException {
        //set up file and stream
        File inFile = new File("sample1.txt");
        FileInputStream fileInputStream = new FileInputStream(inFile);

        //set up an array to read data in
        int fileSize = (int) inFile.length();
        byte[] byteArray = new byte[fileSize];

        //read data in and display them
        fileInputStream.read(byteArray);
        for (int i = 0; i < fileSize; i++) {
            System.out.println(byteArray[i]);
        }

        //input done, so close the stream
        fileInputStream.close();
    }
}
