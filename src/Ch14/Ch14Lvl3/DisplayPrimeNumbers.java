package Ch14.Ch14Lvl3;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPrimeNumbers {
    public static void main(String[] args) {
        /*
        Using the frame layout shown, write a program that displays N prime
        numbers, where N is a value entered in the text field.
        */
        PrimeNumberTextField primeNumberTextField = new PrimeNumberTextField();
        primeNumberTextField.setVisible(true);
    }
}

class PrimeNumberTextField extends JFrame implements ActionListener {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 250;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private static final String EMPTY_STRING = "";
    private static final String NEWLINE = System.getProperty("line.separator");
    private JTextField inputLine;
    private JTextArea textArea;
    private JButton generateButton;

    // constructors
    public PrimeNumberTextField() {
        Container contentPane;

        //  set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle ("Program Ch14TextFrame3");
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        // set the layout manager
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        // arrange text field
        inputLine = new JTextField();
        inputLine.setColumns(10);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);

        //create and place two buttons on the frame
        generateButton = new JButton ("Generate");
        contentPane.add(generateButton);

        // register action listener to the button
        generateButton.addActionListener(this);

        // set the text area
        textArea = new JTextArea();
        textArea.setColumns(22);
        textArea.setRows(8);
        contentPane.add(textArea);

        // add scroll bar to the text area
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setSize(200, 135);
        contentPane.add(scrollText);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String string = inputLine.getText();
            int numberOfPrimes;
            int[] primes;

            try {
                numberOfPrimes = Integer.parseInt(string);
                primes = generateNPrimes(numberOfPrimes);

                for (int prime : primes) {
                    textArea.append(prime + NEWLINE);
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                textArea.setText(exception.getMessage());
            }
        }
    }

    // Method to generate an array of the first 'n' prime numbers
    public static int[] generateNPrimes(int n) {
        int[] primes = new int[n];
        int num = 2; // Start with the first prime number
        int count = 0; // Count of prime numbers found

        while (count < n) {
            if (isPrime(num)) {
                primes[count] = num;
                count++;
            }
            num++;
        }
        return primes;
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}