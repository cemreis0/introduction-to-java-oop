/**
 * Design a currency converter class whose instance will handle conversion of
 * all currencies. A single instance of the new currency converter class you
 * design here will handle all currencies. Instead of having specific conversion
 * methods such as toDollar, toYen, and so forth, the new currency converter
 * class supports one generic conversion method called exchange. The method
 * has three arguments: fromCurrency, toCurrency, and amount. The first two
 * arguments are String and give the names of currencies. The third argument is
 * float. To convert $250 to yen, we write
 * yen = converter.exchange( "dollar", "yen", 250.0 );
 * To set the exchange rate for a currency, we use the setRate method. This
 * method takes two arguments: The first argument is the currency name, and
 * the second argument is the rate. For example, if the exchange rate for yen is
 * 140 yen to $1, then we write
 * converter.setRate( "yen", 140.0 );
 * Use an array to keep track of exchange rate.txt.
 */


package Ch10.Ch10DevEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);
        String firstCurrency, secondCurrency;
        double[] firstCurrencyRates, secondCurrencyRates;
        double amount, result;

        converter.setRate("lira", 30);
        converter.setRate("lira", 29);
        converter.setRate("lira", 25);
        converter.setRate("lira", 26);
        converter.setRate("lira", 27);
        converter.setRate("lira", 28);
        converter.setRate("lira", 28.5);
        converter.setRate("lira", 27.5);
        converter.setRate("eur", 1.15);
        converter.setRate("eur", 1.12);
        converter.setRate("eur", 1.07);
        converter.setRate("eur", 1.17);
        converter.setRate("eur", 1.11);
        converter.setRate("eur", 1.10);
        converter.setRate("eur", 1.20);
        converter.setRate("eur", 1.25);
        converter.setRate("eur", 1.05);

        while (true) {
            try {
                // get input from the user
                System.out.print("Enter the first currency: ");
                firstCurrency = scanner.nextLine();

                System.out.print("Enter the second currency: ");
                secondCurrency = scanner.nextLine();

                System.out.print("Enter amount: ");
                amount = scanner.nextDouble();

                // now get the result
                result = converter.exchange(firstCurrency, secondCurrency, amount);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        firstCurrencyRates = converter.getRates(firstCurrency);
        secondCurrencyRates = converter.getRates(secondCurrency);

        System.out.println(amount + " " + firstCurrency + " = " + result + " " + secondCurrency);
    }
}

class Converter {
    // data members
    private final int NUMBER_OF_RATES = 7; // the number of rate.txt to keep track of
    Map<String, double[]> rates;

    // constructors
    public Converter() {
        rates = new HashMap<>();
    }

    // exchange rate from "currency" to $1
    public void setRate(String currency, double rate) throws IllegalStateException {
        if (rate <= 0) {
            throw new IllegalArgumentException("Invalid rate.");
        }

        double[] currencyRates; // rate array specific to the given currency

        if (!rates.containsKey(currency)) {
            System.out.println("Currency does not exist. Adding " + currency + ".");
            rates.put(currency, new double[NUMBER_OF_RATES]);
            rates.get(currency)[0] = rate;
        }

        if (rates.containsKey(currency)) {
            currencyRates = rates.get(currency);
            for (int i = 0; i < currencyRates.length; i++) {
                // if one of the rate slots is 0.0, set it to the given rate
                if (currencyRates[i] == 0.0) {
                    currencyRates[i] = rate;
                }
            }

            // if the last rate is not 0.0, which means no rate is 0.0, which further means there's no empty slot,
            // shift the entire array by one, then add the given rate to the last slot
            if (currencyRates[currencyRates.length-1] != 0.0) {
                for (int i = 0; i < (currencyRates.length-1); i++) {
                    currencyRates[i] = currencyRates[i+1];
                }
                // add the given rate to the last slot
                currencyRates[currencyRates.length-1] = rate;
            }
        }
    }

    // get all rate.txt of a currency
    public double[] getRates(String currency) throws IllegalArgumentException {
        if (!rates.containsKey(currency)) {
            throw new IllegalArgumentException("Currency does not exist.");
        }

        return rates.get(currency);
    }

    // exchange the first currency to the second currency
    public double exchange(String fromCurrency, String toCurrency, double amount) throws IllegalArgumentException {
        if (!rates.containsKey(fromCurrency)) {
            throw new IllegalArgumentException("The currency to convert from does not exist.");
        }

        if (!rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("The currency to convert to does not exist.");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount.");
        }

        double fromRate = rates.get(fromCurrency)[0];
        double toRate = rates.get(toCurrency)[0];

        return amount / fromRate * toRate;
    }
}