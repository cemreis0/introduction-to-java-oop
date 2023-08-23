import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcherClasses {
    public static void main(String[] args) {
        // Checks whether the input string is a valid identifier. This version uses the Matcher and Pattern classes.
        // matchJavaIdentifierPM();

        // Count the number of times the word 'java' occurs in input sentence using pattern matching.
        // countJavaPM();

        // Displays the positions of the word 'java' in a given string using pattern-matching technique.
        // locateJavaPM();

        qc1();
    }

    public static void matchJavaIdentifierPM() {
        final String STOP = "STOP";
        final String VALID = "Valid Java identifier";
        final String INVALID = "Not a valid Java identifier";
        final String VALID_IDENTIFIER_PATTERN = "[a-zA-Z][a-zA-Z0-9_$]*";
        Scanner scanner = new Scanner(System.in);
        String str, reply;
        Matcher matcher;
        Pattern pattern = Pattern.compile(VALID_IDENTIFIER_PATTERN);

        while (true) {
            System.out.print("Identifier: ");
            str = scanner.nextLine();

            if (str.equals(STOP)) break;

            matcher = pattern.matcher(str);

            if (matcher.matches()) {
                reply = VALID;
            } else {
                reply = INVALID;
            }
            System.out.println(str + ": " + reply + "\n");
        }
    }

    public static void countJavaPM() {
        Scanner scanner = new Scanner(System.in);
        String document;
        int javaCount;
        Matcher matcher;
        Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);

        System.out.println("Sentence: ");
        document = scanner.nextLine();

        javaCount = 0;
        matcher = pattern.matcher(document);
        while (matcher.find()) {
            javaCount++;
        }
        System.out.println("The word 'java' (case-insensitive) occurred " + javaCount + " times.");
    }

    public static void locateJavaPM() {
        Scanner scanner = new Scanner(System.in);
        String document;
        Matcher matcher;
        Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);

        System.out.println("Sentence: ");
        document = scanner.nextLine();

        matcher = pattern.matcher(document);
        while (matcher.find()) {
            System.out.println(document.substring(matcher.start(), matcher.end()) + " found at position " + matcher.start());
        }
    }

    public static void qc1() {
        /*
        Replace the following statements with the equivalent ones using the Pattern
        and Matcher classes.
        a. str.replaceAll("1", "one");
        b. str.matches("alpha");
        */
        String str;
        Pattern pattern = Pattern.compile("1");
        Matcher matcher;

        str = "She won 1st place in the competition by a margin of just 1 point.";
        matcher = pattern.matcher(str);

        str = matcher.replaceAll("one");

        System.out.println(str);


        String str1;
        Pattern pattern1 = Pattern.compile("alpha", Pattern.CASE_INSENSITIVE);
        Matcher matcher1;

        str1 = "alpha";
        matcher1 = pattern1.matcher(str1);

        if (matcher1.matches()) {
            System.out.println(str1);
        } else {
            System.out.println("not ok");
        }


        String str2;
        Pattern pattern2 = Pattern.compile("Java", Pattern.CASE_INSENSITIVE);
        Matcher matcher2;

        str2 = "I'm learning to program in Java to develop versatile and powerful applications.";
        matcher2 = pattern2.matcher(str2);

        if (matcher2.find()) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
