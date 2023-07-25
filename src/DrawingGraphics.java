/*
Chapter 5 Sample Program: Draw a rectangle on a frame window's content pane
*/

import javax.swing.*;
import java.awt.*;

public class DrawingGraphics {
    public static void main(String[] args) {
        // this isn't the preferred approach, the shapes drawn get erased easily
        JFrame win;
        Container contentPane;
        Graphics g;
        Color pink = Color.PINK;

        win = new JFrame("My First Rectangle");
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setSize(300, 200);
        win.setLocation(100,100);
        win.setVisible(true);

        contentPane = win.getContentPane();
        g = contentPane.getGraphics();
        try {Thread.sleep(200);} catch (Exception e) {}
        g.setColor(pink);
        g.drawRect(50, 10, 100, 30);
        g.setColor(Color.RED);
        g.fillRect(175,50,100,30);
    }
}
