public class EnumeratedConstants {
    public static void main(String[] args) {
        enum DayOfWeek {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

        System.out.println("DayOfWeek 0: " + DayOfWeek.SUNDAY + DayOfWeek.valueOf("SUNDAY"));
    }
}
