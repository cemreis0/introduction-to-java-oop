package Ch10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class TemperatureAnalyzerVer3 {
    public static void main(String[] args) {
        AnalyzerVer3 analyzer = new AnalyzerVer3();
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

class AnalyzerVer3 {
    // data members
    private final int NUMBER_OF_MONTHS = 12;
    private Month[] months = new Month[NUMBER_OF_MONTHS];

    // constructors
    public AnalyzerVer3() {
        setMonths();
    }

    private void setMonths() {
        for (int i = 0; i < months.length; i++) {
            if (i % 2 == 1 || i == 0) {
                if (i == 1) {
                    months[i] = new Month(28);
                }
                months[i] = new Month(31);
            } else {
                months[i] = new Month(30);
            }
        }
    }

    public GregorianCalendar getColdestDay() {
        int month = 0, day = 0;
        double tempInMonth;
        GregorianCalendar coldestDay = new GregorianCalendar();

        for (int i = 0; i < months.length; i++) {
            for (int j = 0; j < months[i].getNumberOfDays(); j++) {
                tempInMonth = months[i].getTemps()[j];
                if (tempInMonth < months[month].getTemps()[day]) {
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

        coldestTemp = months[month].getTemps()[day];

        return coldestTemp;
    }

    public GregorianCalendar getHottestDay() {
        int month = 0, day = 0;
        double tempInMonth;
        GregorianCalendar HottestDay = new GregorianCalendar();

        for (int i = 0; i < months.length; i++) {
            for (int j = 0; j < months[i].getNumberOfDays(); j++) {
                tempInMonth = months[i].getTemps()[j];
                if (tempInMonth > months[month].getTemps()[day]) {
                    month = i;
                    day = j;
                }
            }
        }

        HottestDay.set(Calendar.MONTH, month);
        HottestDay.set(Calendar.DAY_OF_MONTH, day);

        return HottestDay;
    }

    public double getHottestTemp() {
        int month, day;
        double HottestTemp;
        GregorianCalendar HottestDay = getHottestDay();

        month = HottestDay.get(Calendar.MONTH);
        day = HottestDay.get(Calendar.DAY_OF_MONTH);

        HottestTemp = months[month].getTemps()[day];

        return HottestTemp;
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

        temp = months[month].getTemps()[day];

        return temp;
    }
}


class Month {
    // data members
    private int numberOfDays;
    private double[] temps;
    private Random random;

    // constructors
    public Month() {
        this(30); // default number of days
        init();
    }
    public Month(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        init();
    }

    // initializer constructor
    private void init() {
        temps = new double[numberOfDays];
        random = new Random();
        setRandomTemps();
    }

    public void setRandomTemps() {
        for (int i = 0; i < temps.length; i++) {
            temps[i] = random.nextDouble(50) - 10;
        }
    }

    public double[] getTemps() {
        return temps;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}