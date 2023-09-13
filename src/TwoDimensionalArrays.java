public class TwoDimensionalArrays {
    public static void main(String[] args) {
        double payScaleTable[][];
        payScaleTable = new double[4][5];

        payScaleTable[0] = new double[]{10.50, 12.00, 14.50, 16.75, 18.00};
        payScaleTable[1] = new double[]{20.50, 22.25, 24.00, 26.25, 28.00};
        payScaleTable[2] = new double[]{34.00, 36.50, 38.00, 40.35, 43.00};
        payScaleTable[3] = new double[]{50.00, 60.00, 70.00, 80.00, 99.99};

        // This code finds the average pay of the grade 2 programmers.
        double average, sum = 0.0;
        for (int j = 0; j < 5; j++) {
            sum += payScaleTable[2][j];
        }
        average = sum / 5;

        // The next example prints out the pay difference between the lowest and highest
        // steps for each grade level.
        double difference;
        for (int i = 0; i < 4; i++) {
            difference = payScaleTable[i][4] - payScaleTable[i][0];
            System.out.println("Pay difference at Grade Level " + i + " is " + difference);
        }

        // This code adds $1.50 to every skill level.
        for (int i = 0; i < payScaleTable.length; i++) {
            for (int j = 0; j < payScaleTable[i].length; j++) {
                payScaleTable[i][j] += 1.50;
                System.out.print(payScaleTable[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println();

        for (double[] row : payScaleTable) {
            for (double pay : row) {
                System.out.print(pay + "   ");
            }
            System.out.println();
        }

        double average2, sum2 = 0.0;
        for (double[] row : payScaleTable) {
            for (double pay : row) {
                sum2 += pay;
            }
        }
        average2 = sum / (payScaleTable.length * payScaleTable[0].length);
        System.out.println();
        System.out.println("average total: " + average2);

        int min;
        int[][] table = {
            {10, 2, 3, 4, 5, 6, 7, 8, 9, 1},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
            {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
            {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
            {71, 72, 73, 74, 75, 76, 77, 0, 79, 80},
            {81, 82, 83, -7, 85, 86, 87, 88, 89, 90},
            {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        };
        min = table[0][0];
        for (int[] row : table) {
            for (int number : row) {
                if (number < min) {
                    min = number;
                }
            }
        }
        System.out.print("min: " + min);
    }
}
