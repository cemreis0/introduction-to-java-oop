public class ProgrammerDefinedClassesPt2 {
    public static void main(String[] args) {
        Fraction f1, f2, f3;
        f1 = new Fraction(1, 2);
        f2 = new Fraction(1, 4);
        f3 = f1.add(f2);
        System.out.println("Sum of " + f1.toString() + " and " +
                f2.toString() + " is " +
                f3.toString()
        );
    }
}

class Fraction {
    // data members
    private int numerator;
    private int denominator;

    // constructor
    public Fraction(int num, int denom) {
        setNumerator(num);
        setDenominator(denom);
    }

    public int getDenominator(){
        return denominator;
    }

    public int getNumerator(){
        return numerator;
    }

    public void setDenominator(int denom) {
        if (denom == 0) {
            //Fatal error
            System.err.println("Fatal Error");
            System.exit(1);
        }
        denominator = denom;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public String toString(){
        return getNumerator() + "/" + getDenominator();
    }

    // Now, let’s study the simplify method that reduces a fraction to its simplest
    // form. How about the following?
    public void simplify(){
        int num = getNumerator();
        int denom = getDenominator();
        int gcd = TheWhileStatement.gcdEuclidean(num, denom);
        setNumerator(num/gcd);
        setDenominator(denom/gcd);
    }
    // Is it acceptable to change the values of the receiving object f1? In this case, no.


    // Here’s the improved version of the simplify method.
    public Fraction simplifyCorrect(){
        int num = getNumerator();
        int denom = getDenominator();
        int gcd = TheWhileStatement.gcdEuclidean(num, denom);
        Fraction simp = new Fraction(num/gcd, denom/gcd);
        return simp;
    }

    public int compare(Fraction frac) {
        double f1value = (double) this.getNumerator() / this.getDenominator();
        double f2value = (double) frac.getNumerator() / frac.getDenominator();

        if (f1value > f2value) {
            return 1;
        } else if (f1value == f2value) {
            return 0;
        } else {
            return -1;
        }
    }

    public Fraction add( Fraction frac) {
        int a, b, c, d;
        Fraction sum;

        a = this.getNumerator();    //get the receiving
        b = this.getDenominator();  //object's num and denom

        c = frac.getNumerator();    //get frac's num
        d = frac.getDenominator();  //and denom

        sum = new Fraction(a * d + b * c, b * d);

        return  sum;
    }
}
