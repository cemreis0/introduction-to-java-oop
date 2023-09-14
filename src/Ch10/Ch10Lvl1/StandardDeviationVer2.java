package Ch10.Ch10Lvl1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StandardDeviationVer2 {
    public static void main(String[] args) {
        StandardDeviationCalculatorVer2 standardDeviationCalculatorVer2 = new StandardDeviationCalculatorVer2();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> realNumbers;
        double standardDeviation;

        while (true) {
            double nextDouble;
            realNumbers = new ArrayList<>();
            try {
                while (true) {
                    System.out.print("Enter a new number (enter 0 to finish adding numbers): ");
                    nextDouble = scanner.nextDouble();
                    if (nextDouble == 0) {
                        break;
                    }
                    realNumbers.add(nextDouble);
                }
                standardDeviationCalculatorVer2.setRealNumbers(realNumbers);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(realNumbers);
        standardDeviation = standardDeviationCalculatorVer2.calculateStandardDeviation();

        System.out.println("Standard deviation: " + standardDeviation);
    }
}

class StandardDeviationCalculatorVer2 {
    // data members
    private ArrayList<Double> realNumbers;

    // constructors
    public StandardDeviationCalculatorVer2() {
        realNumbers = new ArrayList<>();
    }

    public void setRealNumbers(ArrayList<Double> realNumbers) {
        this.realNumbers = realNumbers;
    }

    public List<Double> getRealNumbers() {
        return realNumbers;
    }

    public double calculateStandardDeviation() throws IllegalStateException {
        if (realNumbers.size() == 0) {
            throw new IllegalStateException("The size of the list of real numbers must not be zero.");
        }

        double standardDeviation = 0.0;
        double average = getAverage();

        for (double realNumber : realNumbers) {
            standardDeviation += Math.pow((realNumber - average), 2);
        }

        standardDeviation = Math.sqrt(standardDeviation / realNumbers.size());

        return standardDeviation;
    }

    private double getSum() {
        double sum = 0.0;

        for (double realNumber : realNumbers) {
            sum += realNumber;
        }

        return sum;
    }

    private double getAverage() {
        if (realNumbers.size() == 0) {
            throw new IllegalStateException("The size of the list of real numbers must not be zero.");
        }

        double average, sum;
        sum = getSum();
        average = sum / realNumbers.size();
        return average;
    }
}