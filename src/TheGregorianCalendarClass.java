import java.text.SimpleDateFormat;
import java.util.*;

public class TheGregorianCalendarClass {
    public static void main(String[] args) {
        Ch3FindDayOfWeek();
    }
    public static void GregorianCalendarExample() {
        GregorianCalendar independenceDay = new GregorianCalendar(1776, Calendar.JULY, 4);

        System.out.print(independenceDay);
    }
    public static void Ch3TestCalendar() {
        // Chapter 3 Sample Program: Display Calendar Info
        GregorianCalendar calendar = new GregorianCalendar();

        System.out.println(calendar.getTime());
        System.out.println();
        System.out.println("YEAR           " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH          " + calendar.get(Calendar.MONTH));
        System.out.println("DATE:          " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_YEAR    " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_MONTH   " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("WEEK_OF_YEAR   " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH  " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("AM_PM          " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR           " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY    " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE         " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND         " + calendar.get(Calendar.SECOND));
    }
    public static void Ch3FindDayOfWeek() {
        // Chapter 3 Sample Program: Find the Day of Week of a Given Date
        int year, month, day;

        Scanner scanner = new Scanner(System.in);

        GregorianCalendar cal;
        SimpleDateFormat sdf;

        System.out.print("Enter date (year month date): ");
        year = scanner.nextInt();
        month = scanner.nextInt();
        day = scanner.nextInt();

        cal = new GregorianCalendar(year, month-1, day);
        sdf = new SimpleDateFormat("EEEE");

        System.out.println("Day of Week: " + sdf.format(cal.getTime()));
    }
}
