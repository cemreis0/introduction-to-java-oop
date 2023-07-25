import java.util.Scanner;

public class SelectionStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter test score: ");
        int testScore = scanner.nextInt();
        System.out.print("Enter student age: ");
        int studentAge = scanner.nextInt();
        if (testScore >= 70)
            System.out.println("You have passed."); // no curly braces, single statement
        else
            System.out.println("You have not passed.");

        if (testScore < 70) {
            // curly braces, compound statement
            System.out.println("inside then: " + testScore); // compound statements are good for temporary output
            System.out.println("You did not pass");
            System.out.println("Try harder next time");
        } else { // java convention
            System.out.println("inside else: " + testScore);
            System.out.println("You did pass");
            System.out.println("Keep up the good work");
        }

        if (testScore >= 95) {
            System.out.println("You are an honor student."); // no else block, if-then statement
        }

        // nested if statements
        if (testScore >= 70) {
            if (studentAge < 10) {
                System.out.println("You did a great job.");
            } else {
                System.out.println("You did pass");
            }
        } else {
            System.out.println("You did not pass");
        }

        // this is the same as the code above
        if (testScore >= 70 && studentAge < 10) {
            System.out.println("You did a great job");
        } else {
        //either testScore < 70 OR studentAge >= 10
            if (testScore >= 70) {
                System.out.println("You did pass");
            } else {
                System.out.println("You did not pass");
            }
        }

        // switch statement
        int gradeLevel;
        System.out.println("Grade (Fresh-1, Soph-2...)");
        gradeLevel = scanner.nextInt();

        switch (gradeLevel) {
            case 1: System.out.println("Go to the gymnasium");
            break;

            case 2: System.out.println("Go to the science auditorium");
            break;

            case 3: System.out.println("Go to Halligan Hall Rm 104");
            break;

            case 4: System.out.println("Go to Root Hall Rm 101");
            break;
        }
    }
}
