import java.util.Scanner;

public class ArrayBasics {
    public static void main(String[] args) {
        double[] rainfall = new double[12]; // 12 is the size, namely the number of values in the array
        String[] monthName = new String[12];
        double difference, annualAverage, sum;
        Scanner scanner = new Scanner(System.in);

        monthName[0] = "January";
        monthName[1] = "February";
        monthName[2] = "March";
        monthName[3] = "April";
        monthName[4] = "May";
        monthName[5] = "June";
        monthName[6] = "July";
        monthName[7] = "August";
        monthName[8] = "September";
        monthName[9] = "October";
        monthName[10] = "November";
        monthName[11] = "December";

        /*
        This also works:

        String[] monthName = { "January", "February", "March",
            "April", "May", "June", "July",
            "August", "September", "October",
            "November", "December" };
        */

        sum = 0.0;
        for (int i = 0; i < 12; i++) {
            System.out.print("Rainfall for month " + monthName[i] + ": ");
            rainfall[i] = scanner.nextDouble();
            sum += rainfall[i];
        }

        annualAverage = sum / 12.0;
        System.out.format("Annual Average Rainfall:%5.2f\n\n", annualAverage);

        for (int i = 0; i < 12; i++) {
            System.out.format("%15s", monthName[i]);
            System.out.format("%15.2f", rainfall[i]);
            difference = Math.abs(rainfall[i] - annualAverage);
            System.out.format("%15.2f\n", difference);
        }
    }
}
