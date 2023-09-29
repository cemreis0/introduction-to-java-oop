package Ch10.Ch10Lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FortuneGenerator {
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
