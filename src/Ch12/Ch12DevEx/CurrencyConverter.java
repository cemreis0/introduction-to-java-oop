/**
 * Write a currency converter application. Allow the user to specify the from
 * and to currencies and the amount to exchange. Use the interface of your
 * choice to input these three values. When the application starts, read the
 * exchange rates from a text file rate.txt. Use a text editor to create this text
 * file. By using a text file, you can easily update the exchange rates. The
 * format for the text file is
 * <name of currency> <units per dollar>
 * For example, the following shows how much $1 is worth in five foreign
 * currencies:
 *   - French franc 5.95
 *   - Indonesian rupiah 12900.0
 *   - Japanese yen 123.91
 *   - Mexican peso 9.18
 *   - Papua New Guinea kina 2.381
 */


package Ch12.Ch12DevEx;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException {
        // set up read stream
        File rateFile = new File("files/rate.txt");
        FileReader fileReader = new FileReader(rateFile);
        Scanner readScanner = new Scanner(fileReader);

        // input the get from the user
        Scanner inputScanner = new Scanner(System.in);
        String fromCurrency, toCurrency;
        double amount;

        // store the lines in the file in a list map
        Map<String, Double> rates = new TreeMap<>();
        String[] rateLine;
        String currency;
        double rate;

        // final result
        double result;

        while (readScanner.hasNextLine()) {
            rateLine = readScanner.nextLine().split("\\s+(?=\\S+$)");
            currency = rateLine[0];
            rate = Double.parseDouble(rateLine[1]);
            rates.put(currency, rate);
        }

        // print out the current rates
        System.out.println(rates);

        // get input from the user
        System.out.print("Enter from currency: ");
        fromCurrency = inputScanner.nextLine();
        System.out.print("Enter to currency: ");
        toCurrency = inputScanner.nextLine();
        System.out.print("Enter amount to exchange: ");
        amount = inputScanner.nextDouble();

        // get the relevant data and calculate the result
        try {
            result = amount / rates.get(fromCurrency) * rates.get(toCurrency);
            System.out.println(amount + " " + fromCurrency + " equals " + result + " " + toCurrency);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        Extend any application you have written before by adding a quote-of-the-day dialog.
        When the user starts the application, a quote of the day is
        displayed. Save the quotes in a text file. Use a random number generator
        to select the quote to display. Notice the quotes can be about any information
        (many commercial applications start with a dialog that shows tips on using
        the software).
        */
        // set up the stream
        File quoteFile = new File("files/quoteoftheday.txt");
        FileReader quoteReader = new FileReader(quoteFile);
        Scanner quoteScanner = new Scanner(quoteReader);

        // declare and create a random instance to randomize an index of the quotes
        Random random = new Random();

        // add quote string to quotes list if the next line is not empty
        String quote;
        List<String> quotes = new ArrayList<>();
        while (quoteScanner.hasNextLine()) {
            quote = quoteScanner.nextLine();
            if (quote != null){
                quotes.add(quote);
            }
        }

        // get a random index
        int randomInt = random.nextInt(quotes.size());

        System.out.println("Quote of the day: \"" + quotes.get(randomInt) + "\"");
    }
}
