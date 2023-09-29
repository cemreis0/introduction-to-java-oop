package Ch12.Ch12Lvl1;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class SaveRandomIntsToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n; // number of integers
        int longest, shortest, average, nextInt; // integers read from the file
        Random random = new Random();
        File file = new File("files/integers.dat");

        // set up the streams
        FileOutputStream outputStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // get n from the user
        System.out.print("How many numbers: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            dataOutputStream.writeInt(random.nextInt(100));
        }

        /*
        Write a program that reads the data from the file integers.dat generated in
        Exercise 10. After the data are read, display the smallest, the largest, and the
        average.
        */

        // data writing is over
        dataOutputStream.close();

        // set up the streams
        FileInputStream inputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // set the longest and the shortest integers to the first one, then display it
        longest = shortest = average = dataInputStream.readInt();
        System.out.println(average);

        do {
            nextInt = dataInputStream.readInt();

            System.out.println(nextInt);

            if (nextInt > longest) {
                longest = nextInt;
            }

            if (nextInt < shortest) {
                shortest = nextInt;
            }

            average += nextInt;
        } while (dataInputStream.available() > 0);

        // data reading is over
        dataInputStream.close();

        average = average / n;

        System.out.println("Longest: " + longest);
        System.out.println("Shortest: " + shortest);
        System.out.println("Average: " + average);
    }
}
