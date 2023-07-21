/*
Chapter 4 Exercise 14

Write a WeightConverter class. An instance of this class is created by
passing the gravity of an object relative to the Earth’s gravity (see
Exercise 16 on page 144). For example, the Moon’s gravity is
approximately 0.167 of the Earth’s gravity, so we create a
    WeightConverter instance for the Moon as
    WeightConverter moonWeight;
    moonWeight = new WeightConverter( 0.167 );
To compute how much you weigh on the Moon, you pass your weight on
Earth to the convert method as
    yourMoonWeight = moonWeight.convert( 160 );
Use this class and redo Exercise 16 on page 144.

Mercury 0.4
Venus 0.9
Jupiter 2.5
Saturn 1.1
*/

package Ch4.Ch4Lvl2;

class RelativeWeight {
    public void getRelativeWeight() {
        // weight
        double weight = 75;

        // declare and create WeightConverter instances and pass multiplier arguments
        WeightConverter moonWeight;
        moonWeight = new WeightConverter(0.167);
        WeightConverter mercuryWeight;
        mercuryWeight = new WeightConverter(0.4);
        WeightConverter venusWeight;
        venusWeight = new WeightConverter(0.9);
        WeightConverter jupiterWeight;
        jupiterWeight = new WeightConverter(2.5);
        WeightConverter saturnWeight;
        saturnWeight = new WeightConverter(1.1);

        // print out the results and call convert method
        System.out.println(
                "Weight:            " + weight + "\n" +
                "Moon Weight:       " + moonWeight.convert(weight) + "\n" +
                "Mercury Weight:    " + mercuryWeight.convert(weight) + "\n" +
                "Venus Weight:      " + venusWeight.convert(weight) + "\n" +
                "Jupiter Weight:    " + jupiterWeight.convert(weight) + "\n" +
                "Saturn Weight:     " + saturnWeight.convert(weight) + "\n"
        );
    }
}

public class WeightConverter {
    // data members
    public double multiplier;

    // constructor
    public WeightConverter(double givenMultiplier) {
        multiplier = givenMultiplier;
    }

    // main method
    public static void main(String[] args) {
        RelativeWeight rw = new RelativeWeight();
        rw.getRelativeWeight();
    }

    // returns the relative weight
    public double convert(double givenWeight) {
        return givenWeight * multiplier;
    }

}
