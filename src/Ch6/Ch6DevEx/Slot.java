/*
Write a program that simulates a slot machine. The player starts out with
M coins. The value for M is an input to the program, and you charge 25 cents
per coin. For each play, the player can bet 1 to 4 coins. If the player enters 0
as the number of coins to bet, then the program stops playing. At the end of
the game, the program displays the number of coins left and how much the
player won or lost in the dollar amount. There are three slots on the machine,
and each slot will display one of the three possible pieces: BELL, GRAPE,
and CHERRY. When certain combinations appear on the slots, the machine
will pay the player.

+----+-------------------------+------+
| #  |   Combination           |Payoff|
+----+-------------------------+------+
| 1  | BELL   | BELL   | BELL  |  10  |
| 2  | GRAPE  | GRAPE  | GRAPE |   7  |
| 3  | CHERRY | CHERRY | CHERRY|   5  |
| 4  | BELL   | BELL   | ----- |   3  |
| 5  | BELL   | -----  | BELL  |   3  |
| 6  | -----  | BELL   | BELL  |   3  |
| 7  | GRAPE  | GRAPE  | ----- |   1  |
| 8  | GRAPE  | -----  | GRAPE |   1  |
| 9  | -----  | GRAPE  | GRAPE |   1  |
+----+-------------------------+------+

The symbol ----------- means any piece. If the player bets 4 coins and get
combination 5, for example, the machine pays the player 12 coins.

*/

package Ch6.Ch6DevEx;

import java.util.*;
class Play {
    // data members
    Scanner scanner;
    Slot slot;

    // constructor
    public Play() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        Play play = new Play();
        play.start();
    }

    // start a game loop
    public void start() {
        int numberOfCoins;

        describeProgram();

        do {
            System.out.print("Coin quantity (between 1-4, 0 to exit) - $0.25 each: ");
            numberOfCoins = scanner.nextInt();

            if (numberOfCoins > 4 || numberOfCoins < 0) {
                System.out.println("Invalid coin quantity.");
            } else {
                slot = new Slot(numberOfCoins);

                System.out.println(slot.getPlace1() + " " + slot.getPlace2() + " " + slot.getPlace3());
                System.out.println("Amount you get: " + slot.getAmountWon() + " cents");
                System.out.println("Payoff Factor: " + slot.getPayoffFactor());
                System.out.println("Number of coins: " + slot.getNumberOfCoins() + " x $0.25");
                System.out.println();
            }
        } while (numberOfCoins != 0);
    }

    // describe the program
    public void describeProgram() {
        System.out.println("+----+-------------------------+------+");
        System.out.println("| #  |   Combination           |Payoff|");
        System.out.println("+----+-------------------------+------+");
        System.out.println("| 1  | BELL   | BELL   | BELL  |  10  |");
        System.out.println("| 2  | GRAPE  | GRAPE  | GRAPE |   7  |");
        System.out.println("| 3  | CHERRY | CHERRY | CHERRY|   5  |");
        System.out.println("| 4  | BELL   | BELL   | ----- |   3  |");
        System.out.println("| 5  | BELL   | -----  | BELL  |   3  |");
        System.out.println("| 6  | -----  | BELL   | BELL  |   3  |");
        System.out.println("| 7  | GRAPE  | GRAPE  | ----- |   1  |");
        System.out.println("| 8  | GRAPE  | -----  | GRAPE |   1  |");
        System.out.println("| 9  | -----  | GRAPE  | GRAPE |   1  |");
        System.out.println("+----+-------------------------+------+");
        System.out.println();
    }
}

public class Slot {
    // data members
    private static final int PRICE_PER_COIN = 25; // cents
    private enum Place {BELL, GRAPE, CHERRY} // possibilities
    private int payoffFactor;
    private int combinationNumber;
    private int amountWon;
    private int numberOfCoins;
    private Place place1, place2, place3; // randomly generated places
    Random random;

    // constructor
    public Slot(int givenNumberOfCoins) {
        random = new Random();
        numberOfCoins = givenNumberOfCoins;
        simulate();
    }

    // get number of coins
    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    // get amount won
    public int getAmountWon() {
        return amountWon;
    }

    // get payoff factor
    public int getPayoffFactor() {
        return payoffFactor;
    }

    // get places
    public Place getPlace1() {
        return place1;
    }
    public Place getPlace2() {
        return place2;
    }
    public Place getPlace3() {
        return place3;
    }

    // simulate a randomization
    private void simulate() {
        assignPlaces();
        assignCombinationNumber();
        assignPayoffFactor(combinationNumber);
        calculateAmountWon();
    }

    // assign values to the 3 places
    private void assignPlaces() {
        place1 = randomizePlace();
        place2 = randomizePlace();
        place3 = randomizePlace();
    }

    // randomize a place
    private Place randomizePlace() {
        int number; // 1 - BELL, 2 - GRAPE, 3 - CHERRY
        Place place; // random place
        number = random.nextInt(3) + 1;
        if (number == 1) {
            place = Place.BELL;
        } else if (number == 2) {
            place = Place.GRAPE;
        } else {
            place = Place.CHERRY;
        }
        return place;
    }

    // assign the combination number
    private void assignCombinationNumber() {
        if (place1 == Place.BELL && place2 == Place.BELL && place3 == Place.BELL) {
            combinationNumber = 1;
        } else if (place1 == Place.GRAPE && place2 == Place.GRAPE && place3 == Place.GRAPE) {
            combinationNumber = 2;
        } else if (place1 == Place.CHERRY && place2 == Place.CHERRY && place3 == Place.CHERRY) {
            combinationNumber = 3;
        } else if (place1 == Place.BELL && place2 == Place.BELL) {
            combinationNumber = 4;
        } else if (place1 == Place.BELL && place3 == Place.BELL) {
            combinationNumber = 5;
        } else if (place2 == Place.BELL && place3 == Place.BELL) {
            combinationNumber = 6;
        } else if (place1 == Place.GRAPE && place2 == Place.GRAPE) {
            combinationNumber = 7;
        } else if (place1 == Place.GRAPE&& place3 == Place.GRAPE) {
            combinationNumber = 8;
        } else if (place2 == Place.GRAPE && place3 == Place.GRAPE) {
            combinationNumber = 9;
        } else {
            combinationNumber = 0; // None of the above
        }
    }

    // assign the payoff factor for each possibility
    private void assignPayoffFactor(int combinationNumber) {
        switch (combinationNumber) {
            case 1:
                payoffFactor = 10;
                break;
            case 2:
                payoffFactor = 7;
                break;
            case 3:
                payoffFactor = 5;
                break;
            case 4:
            case 5:
            case 6:
                payoffFactor = 3;
                break;
            case 7:
            case 8:
            case 9:
                payoffFactor = 1;
                break;
            default:
                payoffFactor = 0; // None of the above
                break;
        }
    }

    // calculate amount won
    private void calculateAmountWon() {
        amountWon = numberOfCoins * PRICE_PER_COIN * payoffFactor;
    }
}
