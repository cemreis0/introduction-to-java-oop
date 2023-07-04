import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yy");
        System.out.println(sdf.format(today));
        ch2DisplayDate();
        qc();
    }
    public static void ch2DisplayDate() {
        Date today;
        SimpleDateFormat sdf1, sdf2;
        today = new Date();
        sdf1 = new SimpleDateFormat();
        sdf2 = new SimpleDateFormat("EEEE MM dd yy");
        System.out.println(sdf1.format(today));
        System.out.println(sdf2.format(today));
    }
    public static void qc() {
        Date today = new Date();
        SimpleDateFormat sdf1, sdf2;
        sdf1 = new SimpleDateFormat("dd-MM-yy");
        sdf2 = new SimpleDateFormat("MMM dd, yyyy");
        System.out.println(sdf1.format(today));
        System.out.println("Today is " + sdf2.format(today));
    }
}
