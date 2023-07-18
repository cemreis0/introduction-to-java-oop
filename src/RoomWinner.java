import java.util.Random;

public class RoomWinner {
    public static void main(String[] args) {
        LotteryCard card1, card2, card3;

        card1 = new LotteryCard();
        card2 = new LotteryCard();
        card3 = new LotteryCard();

        card1.spin();
        card2.spin();
        card3.spin();

        System.out.println(
                "Winning card combination" + "\n" + "1 - Red, 2 - Green, 3 - Blue" + "\n" +
                "         color  number" + "\n" +
                "Card 1:    " + card1.getColor() + "  -  " + card1.getNumber() + "\n" +
                "Card 2:    " + card2.getColor() + "  -  " + card2.getNumber() + "\n" +
                "Card 3:    " + card3.getColor() + "  -  " + card3.getNumber()
                );
    }
}

class LotteryCard {
    // data members
    private static final int MAX_NUMBER = 15; // the largest number on a card
    private static final int MIN_NUMBER = 10; // the smallest number on a card
    private static final int NO_NUMBER = 0; // to represent a card before drawing
    private static final int MAX_COLOR = 3; // the largest color on a card
    private static final int MIN_COLOR = 1; // the smallest color on a card
    private static final int NO_COLOR = 0; // to represent a color before drawing
    private int number; // the number on the lottery card
    private int color; // 1 - red, 2 - green, 3 - blue
    private Random random;

    // constructor
    public LotteryCard() {
        random = new Random();
        color = NO_NUMBER;
        number = NO_NUMBER;
    }

    // methods
    // spin the card
    public void spin() {
        number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        color = random.nextInt(MAX_COLOR - MIN_COLOR + 1) + MIN_COLOR;
    }
    // returns the number on this card
    public int getNumber() {
        return number;
    }
    // returns the color on this card
    public int getColor() {
        return color;
    }
}