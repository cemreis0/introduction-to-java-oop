import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextRelatedGUIComponents {
    public static void main(String[] args) {
        /*
        Like a JButton object, an instance of JTextField generates an action event. A
        JTextField object generates an action event when the user presses the Enter key
        while the object is active (it is active when you see the vertical blinking line in it).
        JLabel, on the other hand, does not generate any event. A JTextArea object also generates events,
        specifically the types of events called text events and document
        events. Handling of these events is more involved than handling action events, so to
        keep the discussion manageable, we won’t be processing the JTextArea events.
        We will describe the JTextField class first. We set a JTextField object’s size
        and position and register its action listener in the same way as we did for the
        JButton class. To illustrate its use, we will modify the Ch14JButtonFrameHandler
        by adding a single JTextField object. We will call the new class Ch14TextFrame1.
        The effect of clicking the buttons CANCEL and OK is the same as before. If the user
        presses the Enter key while the JTextField object is active, then we will change the
        title to whatever text is entered in this JTextField object.
        */

        //Ch14TextFrame1 ch14JTextFrame1 = new Ch14TextFrame1();
        //ch14JTextFrame1.setVisible(true);

        //Ch14TextFrame2 ch14TextFrame2 = new Ch14TextFrame2();
        //ch14TextFrame2.setVisible(true);

        Ch14TextFrame3 ch14TextFrame3 = new Ch14TextFrame3();
        ch14TextFrame3.setVisible(true);
    }
}
class Ch14TextFrame1 extends JFrame implements ActionListener {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private JButton cancelButton;
    private JButton okButton;
    private JTextField inputLine;

    public static void main(String[] args) {
        Ch14TextFrame1 frame = new Ch14TextFrame1();
        frame.setVisible(true);
    }

    public Ch14TextFrame1() {
        Container contentPane;

        //set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle ("Program Ch14SecondJFrame");
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        // set the layout manager
        contentPane = getContentPane();
        contentPane.setLayout( new FlowLayout());

        // text field
        inputLine = new JTextField( );
        inputLine.setColumns(22);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);

        //create and place two buttons on the frame
        okButton = new JButton ("OK");
        contentPane.add(okButton);
        cancelButton = new JButton ("CANCEL");
        contentPane.add(cancelButton);

        //register this frame as an action listener of the two buttons
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // action listener method
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) event.getSource();
            String buttonText = clickedButton.getText();
            setTitle("You clicked " + buttonText);
        } else { //the event source is inputLine
            setTitle("You entered '" + inputLine.getText() + "'");
        }
    }
}

/*
Now, let’s add a JLabel object to the frame. In the Ch14TextFrame1 class, we
have one text field without any indication of what this text field is for. A JLabel
object is useful in displaying a label that explains the purpose of the text field. Let’s
modify the Ch14TextFrame1 class by placing the label Please enter your name
above the inputLine text field. We will call the modified class Ch14TextFrame2.
*/
class Ch14TextFrame2 extends JFrame implements ActionListener {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private JButton cancelButton;
    private JButton okButton;
    private JTextField inputLine;
    private  JLabel prompt, image;

    // constructors
    public Ch14TextFrame2() {
        Container contentPane;

        //set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle ("Program Ch14SecondJFrame");
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        // set the layout manager
        contentPane = getContentPane();
        contentPane.setLayout( new FlowLayout());

        // image label
        image = new JLabel();
        image.setIcon(new ImageIcon("files/200w.jpg"));
        image.setSize(50, 50);
        contentPane.add(image);

        // text label
        prompt = new JLabel();
        prompt.setText("Please enter your name");
        prompt.setSize(150, 25);
        contentPane.add(prompt);

        // text field
        inputLine = new JTextField( );
        inputLine.setColumns(22);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);

        //create and place two buttons on the frame
        okButton = new JButton ("OK");
        contentPane.add(okButton);
        cancelButton = new JButton ("CANCEL");
        contentPane.add(cancelButton);

        //register this frame as an action listener of the two buttons
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // action listener method
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) event.getSource();
            String buttonText = clickedButton.getText();
            setTitle("You clicked " + buttonText);
        } else { //the event source is inputLine
            setTitle("You entered '" + inputLine.getText() + "'");
        }
    }
}

/*
Now let’s create the third example by using a JTextArea object. We will call
the sample class Ch14TextFrame3. In this sample program, we will add two buttons
labeled ADD and CLEAR, one text field, and one text area to a frame.
When a text is entered in the text field and the Enter (Return) key is pressed or the ADD button is
clicked, the entered text is added to the list shown in the text area.
*/
class Ch14TextFrame3 extends JFrame implements ActionListener {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 250;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private static final String EMPTY_STRING = "";
    private static final String NEWLINE
            = System.getProperty("line.separator");
    private JButton clearButton;
    private JButton addButton;
    private JTextField inputLine;
    private JTextArea textArea;

    public Ch14TextFrame3() {
        Container contentPane;

        //  set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle ("Program Ch14TextFrame3");
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        // set the layout manager
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout ());

        // set the text area
        textArea = new JTextArea();
        textArea.setColumns(22);
        textArea.setRows(8);
        textArea.setBorder(BorderFactory.createLineBorder(Color.RED));
        textArea.setEditable(false);
        contentPane.add(textArea);

        // add scroll bar to the text area
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setSize(200, 135);
        contentPane.add(scrollText);

        // arrange text field
        inputLine = new JTextField();
        inputLine.setColumns(22);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);

        //create and place two buttons on the frame
        addButton = new JButton ("ADD");
        contentPane.add(addButton);
        clearButton = new JButton ("CLEAR");
        contentPane.add(clearButton);

        //register this frame as an action listener of the two buttons
        clearButton.addActionListener(this);
        addButton.addActionListener(this);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();

            if (clickedButton == addButton) {
                addText(inputLine.getText());
            } else {
                clearText();
            }
        } else {
            addText(inputLine.getText());
        }
    }

    private void addText(String newLine) {
        textArea.append(newLine + NEWLINE);
        inputLine.setText(EMPTY_STRING);
    }

    private void clearText() {
        textArea.setText(EMPTY_STRING);
        inputLine.setText(EMPTY_STRING);
    }
}