import javax.swing.*;
import java.awt.*;

public class CustomizingFrameWindows {
    public static void main(String[] args) {
        // To create a customized user interface, we often define a subclass of the JFrame class.

        // display a Ch14JFrameSubclass1 window
        Ch14JFrameSubclass1 frame1;
        frame1 = new Ch14JFrameSubclass1();
        frame1.setVisible(true);

        // display a Ch14JFrameSubclass2 window
        Ch14JFrameSubclass2 frame2;
        frame2 = new Ch14JFrameSubclass2();
        frame2.setVisible(true);
    }
}

/*
For the Ch14JFrameSubclass1 class, we will add the following default characteristics:
• The title is set to My First Subclass.
• The program terminates when the Close box is clicked.1
• The size of the frame is set to 300 pixels wide and 200 pixels high.
• The frame is positioned at screen coordinate (150, 250).
*/
class Ch14JFrameSubclass1 extends JFrame {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    // constructors
    public Ch14JFrameSubclass1() {
        //set the frame default properties
        setTitle ("My First Subclass");
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
}


/*
We will define this class as an instantiable
main class, so we don’t have to define a separate main class. To make the background
appear in blue, we need to access the content pane of a frame. A frame’s content pane
designates the area of the frame that excludes the title and menu bars and the border.
It is the area we can use to display the content (text, image, etc.). We access the
content pane of a frame by calling the frame’s getContentPane method. And to
change the background color to blue, we call the content pane’s setBackground
method. We carry out these operations in the private changeBkColor method of
Ch14JFrameSubclass2.
*/
class Ch14JFrameSubclass2 extends JFrame {
    // data members
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    public Ch14JFrameSubclass2() {
        //set the frame default properties
        setTitle ("Blue Background JFrame Subclass");
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        changeBkColor();
    }

    private void changeBkColor() {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.BLUE);
    }
}