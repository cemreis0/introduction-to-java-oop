/*
Chapter 4 Exercises 7 and 8

Define a new class named Temperature. The class has two accessors—toFahrenheit and toCelsius—that return the
temperature in the specified unit
and two mutators—setFahrenheit and setCelsius—that assign the temperature
in the specified unit. Maintain the temperature internally in degrees Fahrenheit.
Using this class, write a program that inputs temperature in degrees
Fahrenheit and outputs the temperature in equivalent degrees Celsius.

Using the Temperature class from Exercise 7, write a program that inputs
temperature in degrees Celsius and outputs the temperature in equivalent
degrees Fahrenheit.
*/

package Ch4.Ch4Lvl1;

public class Temperature {
    // data members
    private double tempInF; // temperature in degrees Fahrenheit

    // constructor
    public Temperature() {
        tempInF = 0; // value of the temperature is accessed and mutated
    }

    // main method
    public static void main(String[] args) {
        // sample

        // declare and create the instance
        Temperature temp = new Temperature();

        // assign the value of temperature in Fahrenheit
        temp.setTempInF(100.1);

        // print out the results (Exercise 7)
        System.out.print(
                "Temperature in degrees Fahrenheit:             " + temp.getTempInF() + "\n" +
                "Equivalent temperature in degrees Celsius:     " + temp.getTempInC() + "\n" + "\n"
                );

        // assign the value of temperature in Celsius
        temp.setTempInC(23.5);

        // print out the results (Exercise 8)
        System.out.print(
            "Temperature in degrees Celsius:                " + temp.getTempInC() + "\n" +
            "Equivalent temperature in degrees Fahrenheit:  " + temp.getTempInF()
        );

    }

    // returns the temperature in degrees Fahrenheit
    public double getTempInF() {
        return tempInF;
    }
    // returns the temperature in degrees Celsius
    public double getTempInC() {
        double tempInC;
        tempInC = (tempInF - 32) / 1.8;
        return tempInC;
    }

    // assigns the temperature in degrees Fahrenheit
    public void setTempInF(double temp) {
        tempInF = temp;
    }
    // assigns the temperature in degrees Celsius, converts it to Fahrenheit
    public void setTempInC(double temp) {
        tempInF = temp * 1.8 + 32;
    }
}
