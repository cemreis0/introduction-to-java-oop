package Ch10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class TemperatureAnalyzerVer2 {
    public static void main(String[] args) {
        AnalyzerVer2 analyzer = new AnalyzerVer2();
        GregorianCalendar coldestDay, hottestDay;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
        DecimalFormat df = new DecimalFormat("0.00");
        double coldestTemp, hottestTemp, difference, specificTemp;
        int month, day;
        String isContinue;
        Scanner scanner = new Scanner(System.in);

        coldestDay = analyzer.getColdestDay();
        coldestTemp = (analyzer.getColdestTemp());
        hottestDay = analyzer.getHottestDay();
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
                        System.out.println("Temperature in month " + month + " on day " + day + ": " + specificTemp);
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

class AnalyzerVer2 {
    // data members
    Random random;
    private final int NUMBER_OF_MONTHS = 12;
    private double[][] temps = new double[NUMBER_OF_MONTHS][];
    private final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // constructors
    public AnalyzerVer2() {
        random = new Random();
        setNumberOfDays();
        setRandomTemp();
    }

    // set the number of temps (days actually) of a month
    private void setNumberOfDays() {
        for (int month = 0; month < temps.length; month++) {
            temps[month] = new double[DAYS_IN_MONTH[month]];
        }
    }

    // set random temperature values to temps
    private void setRandomTemp() {
        for (int i = 0; i < temps.length; i++) {
            for (int j = 0; j < temps[i].length; j++) {
                temps[i][j] = random.nextDouble(50)-10;
            }
        }
    }

    public GregorianCalendar getColdestDay() {
        int month = 0, day = 0;
        GregorianCalendar coldestDay = new GregorianCalendar();

        for (int i = 0; i < temps.length; i++) {
            for (int j = 0; j < temps[i].length; j++) {
                if (temps[i][j] < temps[month][day]) {
                    month = i;
                    day = j;
                }
            }
        }

        coldestDay.set(Calendar.MONTH, month);
        coldestDay.set(Calendar.DAY_OF_MONTH, day);

        return coldestDay;
    }

    public double getColdestTemp() {
        int month, day;
        double coldestTemp;
        GregorianCalendar coldestDay = getColdestDay();

        month = coldestDay.get(Calendar.MONTH);
        day = coldestDay.get(Calendar.DAY_OF_MONTH);

        coldestTemp = temps[month][day];

        return coldestTemp;
    }

    public GregorianCalendar getHottestDay() {
        int month = 0, day = 0;
        GregorianCalendar hottestDay = new GregorianCalendar();

        for (int i = 0; i < temps.length; i++) {
            for (int j = 0; j < temps[i].length; j++) {
                if (temps[i][j] > temps[month][day]) {
                    month = i;
                    day = j;
                }
            }
        }

        hottestDay.set(Calendar.MONTH, month);
        hottestDay.set(Calendar.DAY_OF_MONTH, day);

        return hottestDay;
    }

    public double getHottestTemp() {
        int month, day;
        double hottestTemp;
        GregorianCalendar coldestDay = getHottestDay();

        month = coldestDay.get(Calendar.MONTH);
        day = coldestDay.get(Calendar.DAY_OF_MONTH);

        hottestTemp = temps[month][day];

        return hottestTemp;
    }

    public double differenceHottestColdest() {
        double coldestTemp, hottestTemp, difference;

        coldestTemp = getColdestTemp();
        hottestTemp = getHottestTemp();
        difference = Math.abs(hottestTemp - coldestTemp);

        return difference;
    }

    public double getTemperature(int month, int day) {
        double temp;

        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Month must be in range 1-12.");
        }
        if (day > 31 || day < 1) {
            throw new IllegalArgumentException("Day must be in range 1-31.");
        }

        month--;

        temp = temps[month][day];

        return temp;
    }
}