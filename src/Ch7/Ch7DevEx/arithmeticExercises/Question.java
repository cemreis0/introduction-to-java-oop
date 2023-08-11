package Ch7.Ch7DevEx.arithmeticExercises;

import java.util.Random;

public class Question {
    // data members
    private Fraction frac1, frac2, result; // fractions used in operations
    private Operation operation; // randomized operation
    private String symbol; // symbol of the operation
    private static final int OPERATION_UPPER_BOUND = 3; // 0 addition, 1 subtraction, 2 multiplication, 3 division
    private static final int OPERATION_LOWER_BOUND = 0;
    private enum Operation {ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION}
    private Random random;


    // constructors
    public Question() {
        random = new Random();
        generateQuestion();
    }

    // create one randomly generated question
    private void generateQuestion() {
        frac1 = new Fraction();
        frac2 = new Fraction();
        result = new Fraction();

        // assign numerators and denominators to fraction objects
        frac1.setNumerator(random.nextInt(100));
        frac1.setDenominator(random.nextInt(100));
        frac2.setNumerator(random.nextInt(100));
        frac2.setDenominator(random.nextInt(100));

        // get the random operation and its corresponding symbol
        operation = getRandomOperation();
        symbol = getSymbol(operation);

        if (operation == Operation.ADDITION) {
            result = frac1.add(frac2);
        } else if (operation == Operation.SUBTRACTION) {
            result = frac1.subtract(frac2);
        } else if (operation == Operation.MULTIPLICATION) {
            result = frac1.multiply(frac2);
        } else { // operation = Operation.DIVISION
            result = frac1.divide(frac2);
        }

        result = result.simplify();
    }

    // stringify the operation
    public String stringifyOperation() {
        return frac1 + "  " + symbol + "  " + frac2 + " = ?";
    }

    // get the result
    public Fraction getResult() {
        return result;
    }

    // get a random operation
    private Operation getRandomOperation() {
        Operation operation;
        int number = random.nextInt(OPERATION_UPPER_BOUND + 1 - OPERATION_LOWER_BOUND) + OPERATION_LOWER_BOUND;

        switch (number) {
            default:
            case 0: operation = Operation.ADDITION; break;
            case 1: operation = Operation.SUBTRACTION; break;
            case 2: operation = Operation.MULTIPLICATION; break;
            case 3: operation = Operation.DIVISION; break;
        }

        return operation;
    }

    // get the symbol of the given operation, + for addition, - for subtraction, etc.
    private String getSymbol(Operation operation) {
        String symbol = "";

        switch (operation) {
            default:
            case ADDITION: symbol = "+"; break;
            case SUBTRACTION: symbol = "-"; break;
            case MULTIPLICATION: symbol = "*"; break;
            case DIVISION: symbol = "/"; break;
        }

        return symbol;
    }

}
