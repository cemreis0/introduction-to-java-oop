import javax.swing.*;
import java.awt.event.*;

public class HandlingMouseEvents {
    public static void main(String[] args) {
        // Tracks the mouse movement
        Ch14TrackMouseFrame trackMouseFrame = new Ch14TrackMouseFrame();
        trackMouseFrame.setVisible(true);
    }
}

class Ch14TrackMouseFrame extends JFrame implements MouseListener {
    // data members
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 300;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private static final int DOUBLE_CLICK = 2;

    // constructors
    public Ch14TrackMouseFrame() {
        //set frame properties
        setTitle ("TrackMouseFrame");
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        //register self as a mouse event listener
        addMouseListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent event) {
        if (event.getClickCount() == DOUBLE_CLICK) {
            System.exit(0);
        } else {
            int x, y;
            x = event.getX(); //get the x and y coordinates of
            y = event.getY(); //the mouse click point
            System.out.println("[" + x + "," + y + "]" + "\n\n");
        }
    }

    public void mouseEntered (MouseEvent event) {

    }
    public void mouseExited (MouseEvent event) {

    }

    public void mousePressed (MouseEvent event) {
        System.out.println("Down");
    }

    public void mouseReleased(MouseEvent event) {
        System.out.println("Up");
    }
}