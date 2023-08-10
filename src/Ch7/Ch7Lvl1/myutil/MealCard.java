package Ch7.Ch7Lvl1.myutil;

public class MealCard {
    // data members
    private int points;
    private Student owner;

    // constructors
    public MealCard() {
        this(100);
    }
    public MealCard(int points) {
        this.points = points;
    }

    public Student getOwner() {
        return owner;
    }
    public int getPoints() {
        return points;
    }
    public void setOwner(Student owner) {
        this.owner = owner;
    }
    public int addPoints(int points) {
        this.points += points;
        return 1; // return 1 to imply that the operation is successful
    }
    public int deductPoints(int points) {
        int amountAfterDeduction = this.points - points;
        if (amountAfterDeduction < 0) {
            // return -1 if points get negative in a potential transaction, and cancel the operation
            return -1;
        } else {
            this.points -= points;
            return 1;
        }
    }
}
