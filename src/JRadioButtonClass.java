import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JRadioButtonClass {
    public static void main(String[] args) {
        /*
        The JRadioButton class is used to represent a type of button called a radio button.
        Similar to a check-box button, you can select or deselect a radio button. But unlike
        with a check-box button, you can only select one of the radio buttons that belong to
        the same group. Figure 14.23 shows a frame with four radio buttons and one push button.
        We can select exactly one of the four radio buttons at a time because they belong to the same group.
        When we select a new one, then the currently selected radio
        button will get deselected. Radio buttons are useful in allowing the user to select
        one from a list of possible choices.

        We can use the JRadioButton class in almost an identical manner as that for
        the JCheckBox class. Like JCheckBox, JRadioButton generates both action events
        and item events. The key difference is the requirement to add JRadioButton objects
        to a button group, in addition to adding them to a container. Notice that the addition
        of radio buttons to a group is a logical operation (only one radio button in a group
        can be selected at a time), and the addition of radio buttons to a container is a visual layout operation.
        */
        Ch14RadioButtonSample radioButtonSample = new Ch14RadioButtonSample();
        radioButtonSample.setVisible(true);

    }
}

class Ch14RadioButtonSample extends JFrame implements ActionListener, ItemListener {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private JRadioButton[] radioButtons;

    // constructors
    public Ch14RadioButtonSample() {
        Container contentPane;
        JPanel radioPanel, okPanel;
        JButton okButton;
        String[] btnText = {"Java", "C++", "Smalltalk", "Ada"};
        ButtonGroup languageGroup;

        //set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle ("Program Ch14JCheckBoxSample1");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setLayout(new BorderLayout());

        // create and place the radio buttons
        radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.setBorder(BorderFactory.createTitledBorder("Can Program In"));

        // set the button group
        languageGroup = new ButtonGroup();
        radioButtons = new JRadioButton[btnText.length];

        // assign radio buttons
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton(btnText[i]);
            radioButtons[i].addItemListener(this);
            languageGroup.add(radioButtons[i]);
            radioPanel.add(radioButtons[i]);
        }

        radioButtons[0].setSelected(true); //selects the first choice

        //create and place the OK button
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);
        contentPane.add(radioPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String favorite = null;
        int i = 0;

        // iterate over the radioButtons until the selected one is set to the favorite
        while (favorite == null) {
            if (radioButtons[i].isSelected()) {
                favorite = radioButtons[i].getText();
            }
            i++;
        }
        JOptionPane.showMessageDialog(this, "Your favorite language is " + favorite);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton source = (JRadioButton) e.getSource();
        String state;

        if (e.getStateChange() == ItemEvent.SELECTED) {
            state = source.getText() + " is selected";
        } else {
            state = source.getText() + " is deselected";
        }

        setTitle(state);
    }
}