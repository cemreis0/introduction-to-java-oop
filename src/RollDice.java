import java.util.*;

public class RollDice {
    public static void main(String[] args) {
        Die die;

        die = new Die();

        die.roll();

        System.out.println("The result is: " + die.getNumber());
    }
}

class Die {
    // data members
    private static final int MAX_NUMBER = 6; // the largest number on a die
    private static final int MIN_NUMBER = 1; // the smallest number on a die
    private static final int NO_NUMBER = 0; // to represent a die has not yet rolled
    private int number;
    private Random random;

    // constructor
    public Die() {
        random = new Random();
        number = NO_NUMBER;
    }

    // methods
    public void roll() {
        number = random.nextInt (MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}