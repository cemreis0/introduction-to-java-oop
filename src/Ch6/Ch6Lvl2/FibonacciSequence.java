package Ch6.Ch6Lvl2;

public class FibonacciSequence {
    // data members

    // constructor
    public FibonacciSequence() {

    }

    // main method
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        fibonacciSequence.getSequence(3115);
    }

    // get the first n terms of the fibonacci sequence
    public void getSequence(int maxNumber) {
        int limit = 1;

        // for the first two terms
        for (int i = 1; i <= 2; i++) {
            System.out.format("F%-3d %s %d", i, "=", getTerm(i));
            System.out.println();
            if (maxNumber <= getTerm(i)) {
                break;
            }
            limit ++;
        }

        for (int i = 3; i <= maxNumber; i++) {
            System.out.format("F%-3d %s F%1d %s F%1d = %d + %d = %d", i, "=", (i-1), "+", (i-2), getTerm(i-1), getTerm(i-2), getTerm(i));
            System.out.println();
            if (maxNumber <= getTerm(i)) {
                break;
            }
            limit++;
        }
    }

    // get the nth term of the fibonacci sequence
    public int getTerm(int term) {
        if (term == 1 || term == 2) {
            return 1;
        } else {
            return getTerm(term - 1) + getTerm(term - 2);
        }
    }
}
