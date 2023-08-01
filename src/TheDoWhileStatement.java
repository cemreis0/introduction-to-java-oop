import java.util.Scanner;

public class TheDoWhileStatement {
    public static void main(String[] args) {

        int sum = 0, count = 1;

        do {
            sum += count;
            count++;
        } while(count<= 10);

        System.out.println(sum);

        int age;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter an age between 0 and 130: ");
            age = scanner.nextInt();
        } while (age < 0 || age > 130);

        qc1();
    }

    public static void qc1() {
        // Write a do–while loop to compute the sum of the first 30 positive odd integers

        int sum = 0, increment = 1, count = 1;

        do {
            sum += increment;
            increment += 2;
            count++;
        } while (count <= 30);

        System.out.println(sum);
    }
}
