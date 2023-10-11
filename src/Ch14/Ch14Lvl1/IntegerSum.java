/*
Write a program that inputs three integers and outputs their sum. Use the
JOptionPane class for both input and output routines.
*/

package Ch14.Ch14Lvl1;

import javax.swing.*;
import java.awt.*;

public class IntegerSum {
    public static void main(String[] args) {
        String str;
        int i1, i2, i3, sum;

        // set up the frame
        JFrame frame = new JFrame();
        frame.setSize(250, 50);
        frame.setLocation(Window.HEIGHT/2, Window.WIDTH/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // get three integers through option pane
        while (true) {
            try {
                str = JOptionPane.showInputDialog(frame, "Enter integer (1)");
                i1 = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }

        while (true) {
            try {
                str = JOptionPane.showInputDialog(frame, "Enter integer (2)");
                i2 = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }

        while (true) {
            try {
                str = JOptionPane.showInputDialog(frame, "Enter integer (3)");
                i3 = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }

        sum = i1 + i2 + i3;

        // display the sum
        JOptionPane.showMessageDialog(frame, sum);
    }
}
