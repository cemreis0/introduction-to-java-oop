

package Ch12.SampleDevelopment;

import java.io.*;

public class Ch12TestPrintWriter {
    public static void main(String[] args) throws IOException {
        /*
        PrintWriter is an object we use to generate a text file. Unlike DataOutputStream, where we have a separate
        write method for each individual data type,
        PrintWriter supports only two output methods: print and println (for print line). An
        argument to the methods can be any primitive data type. The methods convert the
        parameter to string and output this string value. The constructor of PrintWriter,
        similar to the one for DataOutputStream, requires an output stream as its argument.
        */

        //set up file and stream
        File outFile = new File("sample3.txt");
        FileOutputStream outFileStream = new FileOutputStream(outFile);
        PrintWriter outStream = new PrintWriter(outFileStream);

        //write values of primitive data types to the stream
        outStream.println(987654321);
        outStream.println(11111111L);
        outStream.println(22222222F);
        outStream.println(33333333D);
        outStream.println('A');
        outStream.println(true);

        //output done, so close the stream
        outStream.close();
    }
}
