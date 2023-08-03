public class RecursiveMethods {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(sum(5));
        System.out.println(exponent(5, 3));
        System.out.println(gcd_recursive(21, 27));
    }

    public static int factorial(int N) {
        if (N == 1) {
            return 1;
        } else {
            return N * factorial(N-1);
        }
    }

    public static int sum(int N) {
        if (N == 1) {
            return 1;
        } else {
            return N + sum(N-1);
        }
    }

    public static double exponent(double A, int N) {
        if (N == 1) {
            return A;
        } else {
            return A * exponent(A, N-1);
        }
    }

    public static int gcd_recursive(int m, int n) {
        int result;
        if (m == 0) { //test
            result = n; //end case
        } else {
            result = gcd_recursive(n % m, m); //recursive case
        }
        return result;
    }
}
