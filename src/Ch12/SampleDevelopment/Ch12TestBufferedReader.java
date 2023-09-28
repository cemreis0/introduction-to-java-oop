/*
    Chapter 12 Sample Program: A test program to load data from a file using the readLine method of BufferedReader for high-level String input.
*/

package Ch12.SampleDevelopment;

import java.io.*;

public class Ch12TestBufferedReader {
    public static void main(String[] args) throws IOException {
        /*
        To read the data from a text file, we use the FileReader and BufferedReader
        objects. The relationship between FileReader and BufferedReader is similar to the
        one between FileInputStream and DataInputStream. To read data back from a text file,
        first we need to associate a BufferedReader object to a file.
        */

        //set up file and stream
        File inFile = new File("sample3.data");
        FileReader fileReader = new FileReader(inFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        String str;

        //get integer
        str = bufReader.readLine();
        int i = Integer.parseInt(str);
        //get long
        str = bufReader.readLine();
        long l = Long.parseLong(str);
        //get float
        str = bufReader.readLine();
        float f = Float.parseFloat(str);
        //get double
        str = bufReader.readLine();
        double d = Double.parseDouble(str);
        //get char
        str = bufReader.readLine();
        char c = str.charAt(0);
        //get boolean
        str = bufReader.readLine();
        boolean b = Boolean.parseBoolean(str);

        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(b);

        //input done, so close the stream
        bufReader.close();
    }
}
