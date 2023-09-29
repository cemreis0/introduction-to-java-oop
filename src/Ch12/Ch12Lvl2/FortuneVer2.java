/*
Extend Exercise 18 of Chapter 10 by reading the fortunes from a text file.
Many different types of fortunes can be found at
    http://www.chinese-fortune-cookie.com/
    fortune-cookie-sayings.html
You can select, cut, and paste the list of fortunes into a text file using a text
editor such as the Notepad on the Windows platform. Name this text file
fortunes.txt. If the website has not changed the listing style, then fortunes
are separated by single blank lines. When you input fortunes, you have to
skip blank lines. If you don’t do this, then half of the fortunes in a list are
blank. An alternative is to remove the blank lines, so every line in the text
file is a fortune. You can do this manually by using a text editor or write a
separate program that inputs this text file and output another text file with
all blank lines removed. When the file is very large, then it pays to write a
separate program.
*/

package Ch12.Ch12Lvl2;

import Ch10.Ch10Lvl2.FortuneGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FortuneVer2 {
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

class FortuneGeneratorVer2 {
    // data members
    private List<String> fortunes;
    Random random;

    public FortuneGeneratorVer2() throws IOException {
        setFortunes();
        random = new Random();
    }

    public void setFortunes() throws IOException {
        fortunes = new ArrayList<>();

        // set up the read streams
        File file = new File("files/fortunes");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String fortune;
        do {
            fortune = bufferedReader.readLine();
            fortunes.add(fortune);
        } while (fortune != null);
    }

    public String getRandomFortune() {
        int index = random.nextInt(fortunes.size());

        return fortunes.get(index);
    }
}