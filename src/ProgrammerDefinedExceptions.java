public class ProgrammerDefinedExceptions {
    public static void main(String[] args) {

    }
}

class AgeInputException extends Exception {
    // data members
    private static final String DEFAULT_MESSAGE = "Input out of bounds";
    private int lowerBound;
    private int upperBound;
    private int value;

    public AgeInputException(int lowerBound, int upperBound, int value) {
        this(DEFAULT_MESSAGE, lowerBound, upperBound, value);
    }
    public AgeInputException(String msg, int lowerBound, int upperBound, int value) {
        super(msg);

        if (lowerBound > upperBound) {
            throw new IllegalArgumentException();
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.value = value;
    }

    public int lowerBound() {
        return lowerBound;
    }
    public int upperBound() {
        return upperBound;
    }
    public int value() {
        return value;
    }
}