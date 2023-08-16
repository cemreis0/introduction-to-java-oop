/*
Extend the Fraction class from Chapter 7 by incorporating exception
handling and assertions.
*/

package Ch8.Ch8Lvl2;

public class Fraction {
    // data members
    private int numerator;
    private int denominator;

    // constructors
    public Fraction(){
        this(0, 1);
    }
    public Fraction(int number) {
        this(number, 1);
    }
    public Fraction(Fraction frac) {
        this(frac.getNumerator(), frac.getDenominator());
    }
    public Fraction(int num, int denom) throws IllegalArgumentException {
        if (denom < 0) {
            num = -num;
            denom = -denom;
        }
        if (num == 0) {
            denom = 1;
        }
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        setNumerator(num);
        setDenominator(denom);
    }

    // return great common divisor
    private static int gcd(int m, int n) {
        // precondition assertions
        assert m != 0: "Division by zero";

        int r = n % m;
        while (r !=0) {
            n = m;
            m = r;
            r = n % m;
        }
        return Math.abs(m);
    }

    public static Fraction min(Fraction f1, Fraction f2) {
        // precondition assertions
        assert f1 != null: "Null fraction";
        assert f2 != null: "Null fraction";

        //convert to decimals and then compare
        double f1_dec = f1.decimal();
        double f2_dec = f2.decimal();
        if (f1_dec <= f2_dec) {
            return f1;
        } else {
            return f2;
        }
    }

    public Fraction add(Fraction frac) {
        int a, b, c, d;
        Fraction sum;
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        // precondition assertions
        assert b != 0: "Zero denominator";
        assert d != 0: "Zero denominator";

        sum = new Fraction(a*d + b*c, b*d);
        return sum;
    }

    public Fraction add(int number) {
        Fraction frac = new Fraction(number, 1);
        Fraction sum = add(frac);
        return sum;
    }

    public Fraction subtract(Fraction frac) {
        int a, b, c, d;
        Fraction diff;
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        // precondition assertions
        assert b != 0: "Zero denominator";
        assert d != 0: "Zero denominator";

        diff = new Fraction(a*d - b*c, b*d);
        return diff;
    }

    public Fraction subtract(int number) {
        Fraction frac = new Fraction(number, 1);
        Fraction difference = subtract(frac);
        return difference;
    }

    public Fraction multiply(Fraction frac) {
        int a, b, c, d;
        Fraction product;
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        // precondition assertions
        assert b != 0: "Zero denominator";
        assert d != 0: "Zero denominator";

        product = new Fraction(a*c, b*d);
        return product;
    }

    public Fraction multiply(int number) {
        Fraction frac = new Fraction(number, 1);
        Fraction product = multiply(frac);
        return product;
    }

    public Fraction divide(Fraction frac) {
        int a, b, c, d;
        Fraction quotient;
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        // precondition assertions
        assert b != 0: "Zero denominator in division operation";
        assert c != 0: "Zero denominator in division operation";

        quotient = new Fraction(a*d, b*c);
        return quotient;
    }

    public Fraction divide(int number) {
        Fraction frac = new Fraction(number, 1);
        Fraction quotient = divide(frac);
        return quotient;
    }

    public boolean equals(Fraction frac) {
        Fraction f1 = simplify(); //simplify itself
        Fraction f2 = frac.simplify(); //simplify frac
        return (f1.getNumerator() == f2.getNumerator() && f1.getDenominator() == f2.getDenominator());
    }

    public Fraction simplify(){
        int num = getNumerator();
        int denom = getDenominator();

        if (denom == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }

        int divisor = 1;
        if (num != 0) {
            divisor = gcd(Math.abs(num), denom);
        }

        // postcondition assertions
        assert divisor != 0: "Zero divisor operation";

        return new Fraction(num/divisor, denom/divisor);
    }

    public int getDenominator(){
        return denominator;
    }

    public int getNumerator(){
        return numerator;
    }

    public void setDenominator(int denom) throws IllegalArgumentException {
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        denominator = denom;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public String toString(){
        return getNumerator() + "/" + getDenominator();
    }

    private double decimal(){
        //returns the decimal equivalent
        return (double) getNumerator() / getDenominator();
    }
}
