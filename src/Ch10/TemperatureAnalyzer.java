package Ch10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer();
        GregorianCalendar coldestDay, hottestDay;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
        DecimalFormat df = new DecimalFormat("0.00");
        double coldestTemp, hottestTemp, difference, specificTemp;
        int month, day;
        String isContinue;
        Scanner scanner = new Scanner(System.in);

        coldestDay = analyzer.getColdestDay();
        hottestDay = analyzer.getHottestDay();
        coldestTemp = (analyzer.getColdestTemp());
        hottestTemp = analyzer.getHottestTemp();
        difference = analyzer.differenceHottestColdest();

        System.out.println("Coldest day: " + sdf.format(coldestDay.getTime()) + ", " + df.format(coldestTemp) + " degrees");
        System.out.println("Hottest day: " + sdf.format(hottestDay.getTime()) + ", " + df.format(hottestTemp) + " degrees");
        System.out.println("The difference between the coldest day and the hottest day: " + df.format(difference) + " degrees");

        while (true) {
            System.out.println("Would you like to see the temperature on a specific day (Y-N)?");
            isContinue = scanner.next();

            if (isContinue.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.println("Enter a month (1-12)");
                        month = scanner.nextInt();
                        System.out.println("Enter a day (1-31)");
                        day = scanner.nextInt();
                        specificTemp = analyzer.getTemperature(month, day);
                        System.out.println("Temperature in month " + month +" on day " + day + ": " + specificTemp);
                        break;
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (isContinue.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Invalid response.");
            }
        }
    }
}

class Analyzer {
    // data members
    final int DAYS_IN_YEAR = 365;
    final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    double[] dailyTemperature;

    // constructors
    public Analyzer() {
        dailyTemperature = new double[DAYS_IN_YEAR];
        setRandomTemperatures();
    }

    // set random daily temperature values
    private void setRandomTemperatures() {
        for (int i = 0; i < dailyTemperature.length; i++) {
            dailyTemperature[i] = Math.random() * 50 - 10;
        }
    }

    public double getColdestTemp() {
        double min = dailyTemperature[0];

        for (int i = 0; i < dailyTemperature.length; i++) {
            if (dailyTemperature[i] < min) {
                min = dailyTemperature[i];
            }
        }

        return min;
    }

    public double getHottestTemp() {
        double max = dailyTemperature[0];

        for (int i = 0; i < dailyTemperature.length; i++) {
            if (dailyTemperature[i] > max) {
                max = dailyTemperature[i];
            }
        }

        return max;
    }

    public GregorianCalendar getColdestDay() {
        int minIndex = 0;
        GregorianCalendar coldestDay = new GregorianCalendar();

        for (int i = 0; i < dailyTemperature.length; i++) {
            if (dailyTemperature[i] < dailyTemperature[minIndex]) {
                minIndex = i;
            }
        }

        coldestDay.set(Calendar.DAY_OF_YEAR, minIndex);

        return coldestDay;
    }

    public GregorianCalendar getHottestDay() {
        int maxIndex = 0;
        GregorianCalendar hottestDay = new GregorianCalendar();

        for (int i = 0; i < dailyTemperature.length; i++) {
            if (dailyTemperature[i] > dailyTemperature[maxIndex]) {
                maxIndex = i;
            }
        }

        hottestDay.set(Calendar.DAY_OF_YEAR, maxIndex);

        return hottestDay;
    }

    public double differenceHottestColdest() {
        double coldestTemp, hottestTemp, difference;

        coldestTemp = getColdestTemp();
        hottestTemp = getHottestTemp();
        difference = Math.abs(hottestTemp - coldestTemp);

        return difference;
    }

    public double getTemperature(int month, int day) throws IllegalArgumentException {
        int index = 0;
        double temp;

        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Month must be in range 1-12.");
        }
        if (day > 31 || day < 1) {
            throw new IllegalArgumentException("Day must be in range 1-31.");
        }

        month--;

        for (int i = 0; i < (month-1); i++) {
            index += DAYS_IN_MONTH[i];
        }

        index += day;
        temp = dailyTemperature[index];

        return temp;
    }
}