import java.awt.*;
import java.util.*;

public class ExceptionHandling {
    public static void main(String[] args) {
        int entrantAge, entrantAge2;

        try {
            AgeInputVer5 input = new AgeInputVer5(25, 50);

            entrantAge = input.getAge("Your Age: ");
            System.out.println("Input Okay. Age = " + entrantAge);

        } catch (AgeInputException e) {
            System.out.println("Error: " + e.value() + " is entered. It is " +
                    "outside the valid range of [" + e.lowerBound() +
                    ", " + e.upperBound() + "]");
        }

        try {
            AgeInputVer4 input2 = new AgeInputVer4(25, 50);

            entrantAge2 = input2.getAge("Your age: ");
            System.out.println("Input Okay. Age = " + entrantAge2);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

    class AgeInputVer1 {
        // data members
        private static final String DEFAULT_MESSAGE = "Your age: ";
        private Scanner scanner;

        // constructors
        public AgeInputVer1() {
            scanner = new Scanner(System.in);
        }

        public int getAge() {
            return getAge(DEFAULT_MESSAGE);
        }

        public int getAge(String prompt) {
            System.out.print(prompt);
            int age = scanner.nextInt();

            return age;
        }
    }

    class AgeInputVer2 {
        // data members
        private static final String DEFAULT_MESSAGE = "Your age: ";
        private Scanner scanner;

        // constructors
        public AgeInputVer2() {
            scanner = new Scanner(System.in);
        }

        public int getAge() {
            return getAge(DEFAULT_MESSAGE);
        }

        public int getAge(String prompt) {
            int age;

            while (true) {
                System.out.print(prompt);
                try {
                    age = scanner.nextInt();
                    return age;
                } catch (InputMismatchException e) {
                    scanner.next(); //remove the leftover garbage from the input buffer
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    class AgeInputVer3 {
        // data members
        private static final String DEFAULT_MESSAGE = "Your age: ";
        private Scanner scanner;

        // constructors
        public AgeInputVer3() {
            scanner = new Scanner(System.in);
        }

        public int getAge() {
            return getAge(DEFAULT_MESSAGE);
        }

        public int getAge(String prompt) {
            int age;

            while (true) {
                System.out.print(prompt);
                try {
                    age = scanner.nextInt();

                    if (age < 0) {
                        throw new Exception("Negative age is invalid");
                    }

                    return age;

                } catch (InputMismatchException e) {
                    scanner.next(); //remove the leftover garbage from the input buffer
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                } finally {
                    System.out.println("DONE");
                }
            }

        }
    }

    class AgeInputVer4 {
        // data members
        private static final String DEFAULT_MESSAGE = "Your age: ";
        private static final int DEFAULT_LOWER_BOUND = 0;
        private static final int DEFAULT_UPPER_BOUND = 99;
        private Scanner scanner;
        private int lowerBound, upperBound;

        // constructors
        public AgeInputVer4() {
            init(DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
        }

        public AgeInputVer4(int lowerBound, int upperBound) throws IllegalArgumentException {
            if (lowerBound < 0 || upperBound < 0) {
                throw new IllegalArgumentException("Bound (" + lowerBound + ") cannot be negative.");
            }

            if (lowerBound > upperBound) {
                throw new IllegalArgumentException("Lower bound (" + lowerBound + ") was larger than upper bound (" + upperBound + ")");
            } else {
                init(lowerBound, upperBound);
            }
        }

        private void init(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            scanner = new Scanner(System.in);
        }

        public int getAge() throws Exception {
            return getAge(DEFAULT_MESSAGE);
        }

        public int getAge(String prompt) throws Exception {
            int age;

            while (true) {
                System.out.print(prompt);
                try {
                    age = scanner.nextInt();

                    if (age < 0) {
                        throw new IllegalArgumentException("Illegal value: negative age is invalid.");
                    }

                    return age;

                } catch (InputMismatchException e) {
                    scanner.next(); //remove the leftover garbage from the input buffer
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    class AgeInputVer5 {
        // data members
        private static final String DEFAULT_MESSAGE = "Your age: ";
        private static final int DEFAULT_LOWER_BOUND = 0;
        private static final int DEFAULT_UPPER_BOUND = 99;
        private Scanner scanner;
        private int lowerBound, upperBound;

        // constructors
        public AgeInputVer5() {
            init(DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
        }

        public AgeInputVer5(int lowerBound, int upperBound) throws IllegalArgumentException {
            if (lowerBound > upperBound) {
                throw new IllegalArgumentException("Lower bound (" + lowerBound + ") was larger than upper bound (" + upperBound + ")");
            } else {
                init(lowerBound, upperBound);
            }
        }

        private void init(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            scanner = new Scanner(System.in);
        }

        public int getAge() throws AgeInputException {
            return getAge(DEFAULT_MESSAGE);
        }

        public int getAge(String prompt) throws AgeInputException {
            int age;

            while (true) {
                System.out.print(prompt);
                try {
                    age = scanner.nextInt();

                    if (age < lowerBound || age > upperBound) {
                        throw new AgeInputException("Input out of bound", lowerBound, upperBound, age);
                    }

                    return age;

                } catch (InputMismatchException e) {
                    scanner.next(); //remove the leftover garbage from the input buffer
                    System.out.println(e.getMessage());
                }
            }
        }
    }
