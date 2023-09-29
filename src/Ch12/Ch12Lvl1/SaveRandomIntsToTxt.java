/*
Repeat Exercise 10, but this time, store the numbers in a text file integers.txt.
Open this file with a text editor and verify that you can read the contents.
*/

package Ch12.Ch12Lvl1;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class SaveRandomIntsToTxt {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n; // number of integers
        int longest, shortest, average, nextInt; // integers read from the file
        Random random = new Random();
        File file = new File("files/integers.txt");

        // set up the streams
        FileOutputStream outputStream = new FileOutputStream(file);
        PrintWriter printWriter = new PrintWriter(outputStream);

        // get n from the user
        System.out.print("How many numbers: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            printWriter.println(random.nextInt(100));
        }

        // data writing is over
        printWriter.close();

        /*
        Write a program that reads the data from the file integers.dat generated in
        Exercise 10. After the data are read, display the smallest, the largest, and the
        average.
        */

        // set up the streams
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // set the longest and the shortest integers to the first one, then display it
        String str = bufferedReader.readLine();
        longest = shortest = average = Integer.parseInt(str);
        System.out.println(average);

        do {
            str = bufferedReader.readLine();
            nextInt = Integer.parseInt(str);

            System.out.println(nextInt);

            if (nextInt > longest) {
                longest = nextInt;
            }

            if (nextInt < shortest) {
                shortest = nextInt;
            }

            average += nextInt;
        } while (bufferedReader.ready());

        // data reading is over
        bufferedReader.close();

        average = average / n;

        System.out.println("Longest: " + longest);
        System.out.println("Shortest: " + shortest);
        System.out.println("Average: " + average);
    }
}
