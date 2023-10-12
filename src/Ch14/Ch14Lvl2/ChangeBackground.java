package Ch14.Ch14Lvl2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBackground {
    public static void main(String[] args) {
        /*
        Define a JFrame subclass that has one push button. Initially, the background
        color is white (Color.WHlTE) and the button’s text is ON. When the button
        is clicked, the background of the frame changes to yellow (Color.YELLOW)
        and the text of the button changes to OFF. If the button is clicked again, the
        frame returns to the initial state (ON button text and white background
        color). Because the button text switches back and forth between ON and
        OFF, such button is called a toggle switch. Closing the frame window
        terminates the program.
        */
        ToggleSwitch toggleSwitch = new ToggleSwitch();
        toggleSwitch.setVisible(true);
    }
}

class ToggleSwitch extends JFrame implements ActionListener {
    // data members
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 250;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    JButton switchButton;

    // constructors
    public ToggleSwitch() {
        Container contentPane;

        // set up the frame properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Toggle Switch");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());

        // create the switch button
        switchButton = new JButton("ON");
        switchButton.addActionListener(this);
        contentPane.add(switchButton, BorderLayout.SOUTH);

        // exit on close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Container contentPane = getContentPane();

        if (action.equals("ON")) {
            contentPane.setBackground(Color.YELLOW);
            switchButton.setText("OFF");
        } else {
            contentPane.setBackground(Color.WHITE);
            switchButton.setText("ON");
        }
    }
}