import java.util.*;

public class LoopAndAHalfControl {
    public static void main(String[] args) {
        String name;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Your name: ");
            name = scanner.next();
            if (name.length() >= 3) break;
            System.out.println("Invalid entry. You must enter at least 3 characters. ");
        }

        gcd_LaH(21, 27);
        gcd_LaH(27, 21);
    }

    public static void gcd_LaH(int m, int n) {
        // it doesn't matter which of n and m is bigger
        // this method will work fine either way
        // assume m,n >= 1
        int r;
        while (true) {
            r = n % m;
            if (r == 0) break;
            n = m;
            m = r;
        }

        System.out.println(m);
    }
}
