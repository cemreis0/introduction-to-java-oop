import java.util.*;

public class NumericalInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.print("Enter two integers: ");
        num1 = scanner.nextInt( ); // num1 = Integer.parseInt(scanner.next( )); is equivalent
        num2 = scanner.nextInt( );
        scanner.nextLine(); // Skip to the nex line since nextInt() does not, and we need to get horseName
        System.out.print("num1 = " + num1 + " num2 = " + num2);


        String horseName;
        int age;

        System.out.print("Enter the horse name: ");
        horseName = scanner.nextLine();
        System.out.print("Enter the age: ");
        age = scanner.nextInt( );
        System.out.print(horseName + " is " + age + " years old." );
    }
}
