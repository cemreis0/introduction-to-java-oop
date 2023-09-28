/*
    Chapter 12 Sample Program: Illustrate the use of Scanner to input text file
*/

package Ch12.SampleDevelopment;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ch12TestScanner {
    public static void main(String[] args) throws IOException {
        /*
        Since Java 5.0, we can use the Scanner class introduced in Chapter 3 to input
        data from a text file. Instead of associating a new Scanner object to System.in, we
        can associate it to a File object.
        */

        //open the Scanner
        Scanner scanner = new Scanner(new File("sample3.txt"));
        //get integer
        int i = scanner.nextInt();
        //get integer
        long l = scanner.nextLong();
        //get float
        float f = scanner.nextFloat();
        //get double
        double d = scanner.nextDouble();
        //get char
        char c = scanner.next().charAt(0);
        //get boolean
        boolean b = scanner.nextBoolean();

        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(b);

        //input done, so close the scanner
        scanner.close();
    }
}
