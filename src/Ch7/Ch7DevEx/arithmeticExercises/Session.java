/*
 * This program is an interactive application designed to teach children fraction arithmetic.
 *
 * For each training session, the program generates 10 random questions involving
 * addition, subtraction, division, and multiplication of two fractions. At the start of
 * each session, the user is given the option to specify a time limit for answering the
 * questions. If no time limit is provided, the default time limit is set to 30 seconds.
 *
 * After each question is presented, the program waits for the user's response. Points are
 * awarded to the user based on the following rules:
 *
 *   Answer Time     Points
 *   Correct, Under  10
 *   Correct, Over   6
 *   Wrong, Under    3
 *   Wrong, Over     0
 *
 * Once a session is completed, the program displays the grade distribution and the total
 * points achieved in the following format:
 *
 *   Under Time Limit  Over Time Limit
 *   Correct Answers   4                3
 *   Wrong Answers     2                1
 *   TOTAL POINTS: 64 (40 + 18 + 6 + 0)
 *
 * At the end of each session, the user is given the option to play another session.
 */

package Ch7.Ch7DevEx.arithmeticExercises;

import java.util.Scanner;

public class Session {
    // data members
    private static int timeLimit;
    private Scanner scanner;
    private int points;

    // constructors
    public Session() {
        this(30000);
    }
    public Session(int limit) {
        timeLimit = limit;
        scanner = new Scanner(System.in);
        points = 0;
    }

    // main method
    public static void main(String[] args) {
        Session session = new Session();
        Question exercise;
        Fraction answer;
        Timer timer = new Timer();
        long timeTaken; // time it took for the user to answer
        int isTrue;

        for (int i = 1; i <= 10; i++) {
            exercise = new Question();

            // present the user with the question
            System.out.println("----- Question " + i + " -----");
            System.out.println(exercise.getResult());
            System.out.println(exercise.stringifyOperation());

            // get the answer and time it
            timer.start();
            answer = session.getInput();
            timer.end();
            timeTaken = timer.getTimeTaken();

            // return 1 if the answer is true
            isTrue = session.compareResults(answer, exercise.getResult());

            if (timeTaken <= timeLimit) {
                if (isTrue == 1) {
                    session.addPoints(10);
                } else {
                    session.addPoints(3);
                }
            } else {
                if (isTrue == 1) {
                    session.addPoints(6);
                } else {
                    session.addPoints(0);
                }
            }

            if (isTrue == 1) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }

            System.out.println("Result: " + exercise.getResult());
            System.out.println();
        }

        System.out.println("Exercises are over. Your total points: " + session.getPoints());
    }

    // compare the actual result to the given result
    private int compareResults(Fraction answer, Fraction result) {
        if (answer.equals(result)) {
            return 1; // equal
        } else {
            return 0; // not equal
        }
    }

    // get answer from the user
    private Fraction getInput() {
        String input; // user input
        int numerator, denominator; // Fraction object arguments
        int slashIndex; // index of the slash, the character between numerator and denominator
        Fraction answer; // Fraction object created through user input

        scanner = new Scanner(System.in);

        // get input
        System.out.print("Enter your answer (numerator/denominator): ");
        input = scanner.nextLine();

        // split the input and get two integers
        slashIndex = input.indexOf('/');
        numerator = Integer.parseInt(input.substring(0, slashIndex));
        denominator = Integer.parseInt(input.substring(slashIndex + 1));

        answer = new Fraction(numerator, denominator);

        return answer;
    }

    // add points
    private void addPoints(int amount) {
        points += amount;
    }

    // get points
    public int getPoints() {
        return points;
    }

}
