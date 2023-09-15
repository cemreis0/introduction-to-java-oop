/**
 * Using a list (either an ArrayList or a LinkedList), write a fortune-telling program.
 * Repeatedly prompt the user with the message
 * Fortune (y/N)?
 * If the user enters Y, then display a randomly selected fortune from the list. If
 * the user enters N, then stop the program. Define the class named Fortune.
 * You can define and use a separate main class or include the main method in
 * the Fortune class. Create the fortune list in the constructor. Include at least
 * 10 fortunes. The following are sample fortunes you can use:
 * - You will get a 4.0 GPA this semester.
 * - Happiness is programming.
 * - Satisfaction follows hard work.
 * - Patience is virtue.
 */


package Ch10.Ch10Lvl2;

import java.util.*;

public class Fortune {
    public static void main(String[] args) {
        FortuneGenerator fortuneGenerator = new FortuneGenerator();
        Scanner scanner = new Scanner(System.in);
        String response, fortune;

        while (true) {
            System.out.print("Fortune (y/N)? ");
            response = scanner.next();
            if (response.equals("y")) {
                fortune = fortuneGenerator.getRandomFortune();
                System.out.println(fortune);
            } else {
                System.out.println("Bye!");
                break;
            }
        }
    }
}

class FortuneGenerator {
    // data members
    private List<String> fortunes;
    Random random;

    public FortuneGenerator() {
        setFortunes();
        random = new Random();
    }

    public void setFortunes() {
        fortunes = new ArrayList<>();
        String[] fortuneArray = getFortuneArray();
        fortunes.addAll(Arrays.asList(fortuneArray));
    }

    private String[] getFortuneArray() {
        String[] fortunes = {
                "You will find unexpected happiness today.",
                "A great opportunity is coming your way soon.",
                "Your hard work will pay off in the near future.",
                "Good luck will follow you wherever you go.",
                "You will make new and valuable friendships.",
                "Adventure awaits you in the coming weeks.",
                "Financial success is on the horizon.",
                "A surprise gift will brighten your day.",
                "You have the power to overcome any challenge.",
                "Love and happiness will fill your life."
        };

        return fortunes;
    }

    public String getRandomFortune() {
        int index = random.nextInt(fortunes.size());

        return fortunes.get(index);
    }
}