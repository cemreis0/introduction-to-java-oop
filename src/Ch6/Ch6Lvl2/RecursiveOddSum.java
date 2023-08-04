/*
(Optional) Write a recursive method to compute the sum of the first N
positive odd integers. Note: This is strictly for exercise. You should not write
the real method recursively.
*/

package Ch6.Ch6Lvl2;

public class RecursiveOddSum {
    public RecursiveOddSum() {

    }

    public static void main(String[] args) {
        RecursiveOddSum recursiveOddSum = new RecursiveOddSum();
        System.out.print(recursiveOddSum.oddSum(5));
    }

    public int oddSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*2-1 + oddSum(n-1);
        }
    }
}
