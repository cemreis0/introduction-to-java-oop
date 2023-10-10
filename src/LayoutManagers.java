import javax.swing.*;
import java.awt.*;

public class LayoutManagers {
    public static void main(String[] args) {
        // We will explain the use of layout managers in greater detail by discussing
        // three commonly used layout managers.

        /*
        The most basic layout is java.awt.FlowLayout. In using this layout,
        GUI components are placed in left-to-right order. When the component does not fit on the same
        line, left-to-right placement continues on the next line. As a default, components on
        each line are centered. When the frame containing the component is resized, the
        placement of components is adjusted accordingly.
        */

        /*
        Before we add any components, first we assign the desired layout manager to the container.
        We can change it to left or right alignment as
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT)); or RIGHT
        */
        // Ch14FlowLayoutSample ch14FlowLayoutSample = new Ch14FlowLayoutSample();
        // ch14FlowLayoutSample.setVisible(true);

        /*
        The second layout manager is java.awt.BorderLayout. This layout manager divides the container into five regions:
        center, north, south, east, and west. Figure 14.13
        shows five buttons placed in these five regions. The right frame in the figure is the state
        after it is resized. The north and south regions expand or shrink in height only, the east
        and west regions expand or shrink in width only, and the center region expands or
        shrinks on both height and width. Not all regions have to be occupied.
        */
        // Ch14BorderLayoutSample ch14BorderLayoutSample = new Ch14BorderLayoutSample();
        // ch14BorderLayoutSample.setVisible(true);

        /*
        The third layout manager is java.awt.GridLayout. This layout manager places
        GUI components on equal-size N x M grids. Figure 14.15 shows five buttons placed
        on 2 x 3 grids. Components are placed in top-to-bottom, left-to-right order.
        */
        // Ch14GridLayoutSample ch14GridLayoutSample = new Ch14GridLayoutSample();
        // ch14GridLayoutSample.setVisible(true);

        /*
        It is possible not to use any layout manager. If we do not use one, then we
        place GUI objects on the frame’s content pane by explicitly specifying their position and size.
        We call this approach absolute positioning. Although layout managers
        are very useful in practical applications, knowing various layout managers is not
        indispensable for learning object-oriented and event-driven programming. So using
        absolute positioning is acceptable while learning object-oriented and event-driven
        programming. Keep in mind, however, that to build practical GUI-based Java programs,
        we must learn how to use layout managers effectively.
        To use absolute positioning, we set the layout manager of a frame’s content
        pane to none by passing null to the setLayout method.
        */
        Ch14AbsolutePositioning ch14AbsolutePositioning = new Ch14AbsolutePositioning();
        ch14AbsolutePositioning.setVisible(true);
    }
}

class Ch14FlowLayoutSample extends JFrame {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    // constructors
    public Ch14FlowLayoutSample() {
        // get the container
        Container contentPane;
        JButton button1, button2, button3, button4, button5;

        // set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle ("Program Ch14FlowLayoutSample");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        contentPane = getContentPane( );
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new FlowLayout());

        // create and place four buttons on the content pane
        button1 = new JButton("button 1");
        button2 = new JButton("button 2");
        button3 = new JButton("button 3");
        button4 = new JButton("button 4");
        button5 = new JButton("button 5");
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        contentPane.add(button5);

        // register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class Ch14BorderLayoutSample extends JFrame {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    // constructors
    public Ch14BorderLayoutSample() {
        Container contentPane;
        JButton button1, button2, button3, button4, button5;

        // set the frame properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Program Ch14BorderLayoutSample");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        // set the layout manager
        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout(10, 20)); // 10-20 are width-height gaps between regions

        //create and place four buttons on the content pane
        button1 = new JButton("button 1");
        button2 = new JButton("button 2");
        button3 = new JButton("button 3");
        button4 = new JButton("button 4");
        button5 = new JButton("button 5");
        contentPane.add(button1, BorderLayout.NORTH);
        contentPane.add(button2, BorderLayout.SOUTH);
        contentPane.add(button3, BorderLayout.EAST);
        contentPane.add(button4, BorderLayout.WEST);
        contentPane.add(button5, BorderLayout.CENTER);

        // register exit upon closing as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class Ch14GridLayoutSample extends JFrame {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    // constructors
    public Ch14GridLayoutSample() {
        Container contentPane;
        JButton button1, button2, button3, button4, button5;

        // set the frame properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Program Ch14BorderLayoutSample");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        // set the layout manager
        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridLayout(0, 2));

        //create and place four buttons on the content pane
        button1 = new JButton("button 1");
        button2 = new JButton("button 2");
        button3 = new JButton("button 3");
        button4 = new JButton("button 4");
        button5 = new JButton("button 5");
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        contentPane.add(button5);

        // register exit upon closing as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class Ch14AbsolutePositioning extends JFrame {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 220;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 30;
    private JButton cancelButton;
    private JButton okButton;

    // constructors
    public Ch14AbsolutePositioning() {
        Container contentPane = getContentPane();

        //set the frame properties
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle ("Program Ch14AbsolutePositioning");
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        //set the content pane properties
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);

        //create and place two buttons on the frame's content pane
        okButton = new JButton("OK");
        okButton.setBounds(70, 125, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(okButton);

        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(160, 125, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(cancelButton);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}