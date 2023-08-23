import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        // Checks whether the input string is a valid identifier.
        // matchJavaIdentifier();

        // Checks whether the input string is a valid identifier.
        // matchPhoneIdentifier();
    }

    public static void matchJavaIdentifier() {
        final String STOP = "STOP";
        final String VALID = "Valid Java identifier";
        final String INVALID = "Not a valid Java identifier";
        final String VALID_IDENTIFIER_PATTERN = "[a-zA-Z][a-zA-Z0-9_$]*";

        Scanner scanner = new Scanner(System.in);
        String str, reply;

        while (true) {
            System.out.print ("Identifier: ");
            str = scanner.next( );

            if (str.equals(STOP)) break;

            if (str.matches(VALID_IDENTIFIER_PATTERN)) {
                reply = VALID;
            } else {
                reply = INVALID;
            }

            System.out.println(str + ": " + reply + "\n");
        }
    }

    public static void matchPhoneIdentifier() {
        final String STOP = "0";
        final String VALID = "Valid phone number";
        final String INVALID = "Not a valid phone number";
        final String VALID_PHONE_PATTERN = "5[0-5]{2}-[0-9]{3}-[0-9]{4}";

        Scanner scanner = new Scanner (System.in);
        String phoneStr, reply;

        while (true) {
            System.out.print ("Phone#: ");
            phoneStr = scanner.next( );

            if (phoneStr.equals(STOP)) break;

            if (phoneStr.matches(VALID_PHONE_PATTERN)) {
                reply = VALID;
            } else {
                reply = INVALID;
            }
            System.out.println(phoneStr + ": " + reply + "\n");
        }
    }
}
