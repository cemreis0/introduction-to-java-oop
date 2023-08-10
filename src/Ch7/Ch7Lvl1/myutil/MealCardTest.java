package Ch7.Ch7Lvl1.myutil;

public class MealCardTest {
    public static void main(String[] args) {
        Student s1 = new Student("Cem");
        Student s2 = new Student();
        MealCard mc1 = new MealCard();
        MealCard mc2 = new MealCard(250);

        // print out the initial values that are tested, before any transaction
        System.out.println(
                "--Phase 1--" + "\n" +
                "Student 1      " + "name: " + s1.getName() +                                     "\n" +
                "Student 2      " + "name: " + s2.getName() +                                     "\n" + "\n" +
                "Meal Card 1    " + "owner: " + mc1.getOwner() + ", points: " + mc1.getPoints() + "\n" +
                "Meal Card 2    " + "owner: " + mc2.getOwner() + ", points: " + mc2.getPoints() + "\n" + "\n"
        );

        // set owner to the meal cards
        mc1.setOwner(s1);
        mc2.setOwner(s2);

        // print out the phase 2 testing
        System.out.println(
                "--Phase 2--" + "\n" +
                "Student 1      " + "name: " + s1.getName() +                                               "\n" +
                "Student 2      " + "name: " + s2.getName() +                                               "\n" + "\n" +
                "Meal Card 1    " + "owner: " + mc1.getOwner().getName() + ", points: " + mc1.getPoints() + "\n" +
                "Meal Card 2    " + "owner: " + mc2.getOwner().getName() + ", points: " + mc2.getPoints() + "\n" + "\n"
        );

        // make transactions to the meal cards
        mc1.addPoints(100); // points: 200
        mc1.deductPoints(50); // points: 150
        mc2.addPoints(150); // points: 400
        mc2.deductPoints(250); // points: 150

        System.out.println(
                "--Phase 3--" + "\n" +
                "Student 1      " + "name: " + s1.getName() +                                               "\n" +
                "Student 2      " + "name: " + s2.getName() +                                               "\n" + "\n" +
                "Meal Card 1    " + "owner: " + mc1.getOwner().getName() + ", points: " + mc1.getPoints() + "\n" +
                "Meal Card 2    " + "owner: " + mc2.getOwner().getName() + ", points: " + mc2.getPoints() + "\n" + "\n"
        );

        // make an illegal transaction, i.e. the points get negative
        int result1 = mc1.deductPoints(400);
        int result2 = mc2.deductPoints(100);

        System.out.println("--Phase 4--" + "\n");

        // meal card 1
        if (result1 == -1) {
            System.out.println("Meal Card 1: Not enough funds. Transaction cancelled. points: " + mc1.getPoints());
        } else {
            System.out.println("Meal Card 1: " + mc1.getPoints());
        }

        // meal card 2
        if (result2 == -1) {
            System.out.println("Meal Card 2: Not enough funds. Transaction cancelled. points: " + mc2.getPoints());
        } else {
            System.out.println("Meal Card 2: " + mc2.getPoints());
        }
    }
}
