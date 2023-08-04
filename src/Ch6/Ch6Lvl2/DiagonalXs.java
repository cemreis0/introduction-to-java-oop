package Ch6.Ch6Lvl2;

public class DiagonalXs {
    // data members

    // constructor
    public DiagonalXs() {

    }

    // main method
    public static void main(String[] args) {
        DiagonalXs diagonalXs = new DiagonalXs();
        diagonalXs.printCross(3);
    }

    // print out the xs
    public void printXs() {
        for (int i = 1; i <= 50; i++) {
            System.out.format("%" + i*2 + "s", "x");
            System.out.println();
        }
    }

    public void printCross(int number) {
        for (int i = 1; i <= number / 2; i++) {
            System.out.format("%" + i + "s%" + (number - i)*2 + "s", "x", "x");
            System.out.println();
        }
        System.out.format("%" + number + "s", "x");
        System.out.println();
        for (int i = number / 2; i >= 1; i--) {
            System.out.format("%" + i + "s%" + (number - i)*2 + "s", "x", "x");
            System.out.println();
        }
    }
}
