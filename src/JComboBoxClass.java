import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JComboBoxClass {
    public static void main(String[] args) {
        // drop down list

        /*
        This class is similar to the JRadioButton
        class in that it also allows the user to select one item from a list of possible choices. The
        difference between the two lies in how the choices are presented to the user. Another
        name for a combo box is a drop-down list, which is more descriptive of its interaction
        style.

        A JComboBox object generates both action events and item events. An action
        event is generated every time a JComboBox is clicked (note it is not that common to
        process action events of JComboBox). Every time an item different from the currently selected item is selected,
        an item event is generated and the itemStateChanged method is called twice. The first time is for the
        deselection of the currently
        selected item, and the second is for the selection of the new item. Notice that when
        the same item is selected again, no item event is generated.

        To find out the currently selected item, we call the getSelectedItem method of
        JComboBox. Because the return type of this method is Object, we must typecast to
        the correct type.
        */

        Ch14ComboBoxSample comboBoxSample = new Ch14ComboBoxSample();
        comboBoxSample.setVisible(true);
    }
}

class Ch14ComboBoxSample extends JFrame implements ActionListener, ItemListener {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private JComboBox comboBox;

    // constructors
    public Ch14ComboBoxSample() {
        Container contentPane;
        JPanel comboPanel, okPanel;
        JButton okButton;
        String[] comboBoxItem = {"Java", "C++", "Smalltalk", "Ada"};

        //set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle ("Program Ch14JComboBoxSample");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());

        //create and place a combo box
        comboPanel = new JPanel(new FlowLayout());
        comboPanel.setBorder(BorderFactory.createTitledBorder("Pick your favorite"));
        comboBox = new JComboBox(comboBoxItem);
        comboBox.addItemListener(this);
        comboPanel.add(comboBox);

        //create and place the OK button
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);
        contentPane.add(comboPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String favorite;
        int location;

        favorite = (String) comboBox.getSelectedItem();
        location = comboBox.getSelectedIndex();

        JOptionPane.showMessageDialog(this, "Currently selected item " + favorite + " is at position " + location);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String state;

        if (e.getStateChange() == ItemEvent.SELECTED) {
            state = e.getItem().toString() + " is selected";
        } else {
            state = e.getItem().toString() + " is deselected";
        }
        setTitle(state);
    }
}