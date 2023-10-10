import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class JListClass {
    public static void main(String[] args) {
        /*
        We can construct a JList object in a manner identical to the way we construct
        a JComboBox object, that is, by passing an array of String.

        With JList, we have an option of specifying one of the three selection modes:
        single-selection, single-interval, and multiple-interval. The single-selection mode
        allows the user to select only one item at a time. The single-interval mode allows the
        user to select a single contiguous interval. And the multiple-interval mode allows
        the user to select multiple contiguous intervals (each interval will include one or
        more items). The multiple-interval mode is the default mode.

        Because multiple items can be selected, we use getSelectedValues and
        getSelectedIndices to retrieve an array of selected items and an array of the indices
        of the selected items, respectively.

        The return type of getSelectedValues is an array of Object, so we typecast each item
        in the name array to String before printing it on System.out. If we know the selection mode is single selection,
        then we can use getSelectedValue and getSelectedIndex instead. Notice in the code that we are not adding a
        JList object directly to a panel. Instead, we wrap it in a JScrollPane and add this JScrollPane to a
        panel because JList itself does not include scroll bars.
        */

        Ch14ListSample listSample = new Ch14ListSample();
        listSample.setVisible(true);
    }
}

class Ch14ListSample extends JFrame implements ActionListener, ListSelectionListener {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 250;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private JList list;

    // constructors
    public Ch14ListSample() {
        Container contentPane;
        JPanel listPanel, okPanel;
        JButton okButton;
        String[] names = {"Ape", "Bat", "Bee", "Cat",
                "Dog", "Eel", "Fox", "Gnu",
                "Hen", "Man", "Sow", "Yak"};

        //set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle ("Program Ch14JListSample2");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());

        //create and place a JList
        listPanel = new JPanel(new GridLayout(0,1));
        listPanel.setBorder(BorderFactory.createTitledBorder("Three-letter Animal Names"));
        list = new JList(names);
        list.addListSelectionListener(this);
        listPanel.add(new JScrollPane(list));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //create and place the OK button
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);

        contentPane.add(listPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List name;
        int[] loc;

        name = list.getSelectedValuesList();
        loc = list.getSelectedIndices();

        System.out.println("Currently selected animal names are");
        for (int i = 0; i < name.size(); i++) {
            System.out.println((String) name.get(i) + " at position " + loc[i]);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String state;

        if (e.getValueIsAdjusting()) {
            state = "value is adjusting";
        } else {
            state = "value is adjusting";
        }

        setTitle(state);
    }
}