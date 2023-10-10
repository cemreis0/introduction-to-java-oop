import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIProgrammingBasics {
    public static void main(String[] args) {
        /*
        We will develop a sample frame window that illustrates the fundamentals of GUI programming.
        The sample frame window has two buttons labeled
        CANCEL and OK. When you click the CANCEL button, the window’s title is changed
        to You clicked CANCEL. Likewise, when you click the OK button, the window’s title
        is changed to You clicked OK.
        */
         /*
         There are two key aspects involved in GUI programming. One is the placement of GUI objects
         on the content pane of a frame, and the other is the handling of
         events generated by these GUI objects.
         */

        // button placement
        // The type of button we use here is called a push button.
        JButton cancelButton, okButton;
        cancelButton = new JButton("CANCEL"); // the text passed in is a label
        okButton = new JButton("OK");

        /*
        There are two general approaches to placing buttons (and other types of GUI
        objects) on a frame’s content pane, one that uses a layout manager and another that
        does not. The layout manager for a container is an object that controls the placement
        of the GUI objects. For example, the simplest layout manager called FlowLayout
        places GUI objects in the top-to-bottom, left-to-right order. If we do not use any layout manager,
        then we place GUI objects by explicitly specifying their position and
        size on the content pane. We call this approach absolute positioning. In this section,
        we will use FlowLayout.
        */

        // To use the flow layout, we set the layout manager of a frame’s content pane by
        // passing an instance of FlowLayout to the setLayout method:
        // contentPane.setLayout(new FlowLayout())

        // display CH14JButtonFrame
        Ch14JButtonFrame buttonFrame = new Ch14JButtonFrame();
        buttonFrame.setVisible(true);

        // handling button events
        /*
        An action such as clicking a button is called an event, and the mechanism to process the events event handling. The
        event-handling model of Java is based on the concept known as the delegation based
        event model. With this model, event handling is implemented by two types of
        objects: event source objects and event listener objects.
        A GUI object, such as a button, where the event occurs is called an event, or
        simply, the event source. We say an event source generates events. So, for example,
        when the user clicks on a button, the corresponding JButton object will generate an
        action event. When an event is generated, the system notifies the relevant event listener objects.
        An event listener object, or simply an event listener, is an object that
        includes a method that gets executed in response to generated events. It is possible
        for a single object to be both an event source and an event listener.
        Among the many different types of events, the most common one is called an
        action event. For example, when a button is clicked or a menu item is selected, an
        event source will generate an action event. For the generated events to be processed,
        we must associate, or register, event listeners to the event sources. If the event
        sources have no registered listeners, then generated events are simply ignored.
        For each type of event, we
        have a corresponding listener. For example, we have action listeners for action
        events, window listeners for window events, mouse listeners for mouse events, and
        so forth. Event types other than action events are discussed later in this chapter. If
        we wish to process the action events generated by a button, then we must associate
        an action listener to the button.
        */

    }
}

class Ch14JButtonFrame extends JFrame {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private JButton cancelButton;
    private JButton okButton;

    // constructors
    public Ch14JButtonFrame() {
        Container contentPane = getContentPane();

        //set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle ("Program Ch14JButtonFrame");
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        // set the layout manager
        contentPane.setLayout(new FlowLayout());

        //create and place two buttons on the frame's content pane
        okButton = new JButton("OK");
        contentPane.add(okButton);
        cancelButton = new JButton("CANCEL");
        contentPane.add(cancelButton);

        // An action listener is associated to an action event source by calling the event
        // source’s addActionListener method with this action listener as its argument.
        ButtonHandler handler = new ButtonHandler();
        cancelButton.addActionListener(handler);
        okButton.addActionListener(handler);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class ButtonHandler implements ActionListener {
    // change the title when the button is clicked
    public void actionPerformed(ActionEvent evt) {
        // retrieve the text of the clicked button
        // String buttonText = evt.getActionCommand(); or
        JButton clickedButton = (JButton) evt.getSource();
        String buttonText = clickedButton.getText();

        // retrieve the root pane, then get the frame that contains this root pane
        JRootPane rootPane = clickedButton.getRootPane();
        Frame frame = (Frame) rootPane.getParent();
        frame.setTitle("You clicked " + buttonText);

        System.out.println(evt.getActionCommand());
    }
}