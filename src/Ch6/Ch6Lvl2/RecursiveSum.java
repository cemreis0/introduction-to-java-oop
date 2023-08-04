/*
(Optional) Write a recursive method to compute the sum of the first N
positive integers. Note: This is strictly for exercise. You should not write the
real method recursively.
*/

package Ch6.Ch6Lvl2;

public class RecursiveSum {
    public RecursiveSum() {

    }

    public static void main(String[] args) {
        RecursiveSum sum = new RecursiveSum();
        System.out.print(sum.sum(10));
    }

    public int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n-1);
        }
    }
}
