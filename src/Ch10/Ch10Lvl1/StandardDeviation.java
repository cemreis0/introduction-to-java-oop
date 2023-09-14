package Ch10.Ch10Lvl1;

import java.util.Scanner;

public class StandardDeviation {
    public static void main(String[] args) {
        StandardDeviationCalculator standardDeviationCalculator = new StandardDeviationCalculator();
        Scanner scanner = new Scanner(System.in);
        int numberOfRealNumbers;
        double[] realNumbers;
        double standardDeviation;

        while (true) {
            try {
                System.out.print("How many numbers? ");
                numberOfRealNumbers = scanner.nextInt();
                realNumbers = new double[numberOfRealNumbers];
                standardDeviationCalculator.setNumberOfRealNumbers(numberOfRealNumbers);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                for (int i = 0; i < realNumbers.length; i++) {
                    System.out.print("Number " + (i+1) + ": ");
                    realNumbers[i] = scanner.nextDouble();
                }
                standardDeviationCalculator.setRealNumbers(realNumbers);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        standardDeviation = standardDeviationCalculator.calculateStandardDeviation();

        System.out.println("Standard deviation: " + standardDeviation);
    }
}

class StandardDeviationCalculator {
    // data members
    private int numberOfRealNumbers;
    private double[] realNumbers;

    // constructors
    public StandardDeviationCalculator() {
        this(0);
    }
    public StandardDeviationCalculator(int numberOfRealNumbers) {
        this.numberOfRealNumbers = numberOfRealNumbers;
        realNumbers = new double[numberOfRealNumbers];
    }

    public void setNumberOfRealNumbers(int numberOfRealNumbers) throws IllegalArgumentException {
        if (numberOfRealNumbers < 1) {
            throw new IllegalArgumentException("The number of real number must not be less than 1.");
        }
        this.numberOfRealNumbers = numberOfRealNumbers;
        realNumbers = new double[numberOfRealNumbers];
    }

    public int getNumberOfRealNumbers() {
        return numberOfRealNumbers;
    }

    public void setRealNumbers(double[] realNumbers) {
        if (numberOfRealNumbers == 0) {
            throw new IllegalStateException("The number of real numbers has not been set.");
        }

        if (realNumbers.length != this.realNumbers.length) {
            throw new IllegalArgumentException("The number of real numbers in the given array does not match the required number of real numbers.");
        }

        this.realNumbers = realNumbers;
    }

    public double[] getRealNumbers() {
        return realNumbers;
    }

    public double calculateStandardDeviation() throws IllegalStateException {
        if (numberOfRealNumbers == 0) {
            throw new IllegalStateException("The number of real numbers has not been set.");
        }

        double standardDeviation = 0.0;
        double average = getAverage();

        for (double realNumber : realNumbers) {
            standardDeviation += Math.pow((realNumber - average), 2);
        }

        standardDeviation = Math.sqrt(standardDeviation / numberOfRealNumbers);

        return standardDeviation;
    }

    private double getSum() {
        double sum = 0.0;

        for (double realNumber : realNumbers) {
            sum += realNumber;
        }

        return  sum;
    };

    private double getAverage() {
        if (numberOfRealNumbers == 0) {
            throw new IllegalStateException("The number of real numbers has not been set.");
        }

        double average, sum;
        sum = getSum();
        average = sum / numberOfRealNumbers;
        return average;
    }
}