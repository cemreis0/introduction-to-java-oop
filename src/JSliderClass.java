import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JSliderClass {
    public static void main(String[] args) {
        /*
        The JSlider class represents a slider in which the user can move a nob to a desired
        position. The position of the nob on a slider determines the selected value.
        This is a classic example of sliders
        where the user moves the three nobs to set the red, green, blue (RGB) value in
        selecting a color. Values for the R, G, and B range from 0 to 255, inclusive. Some
        of the properties we can set for a JSlider object are the minimum and maximum range
        of values, whether to display the tick marks, the spacing of major and minor tick
        marks, whether to display the label for the major tick marks, and the placement
        orientation (either vertical or horizontal).

        When a nob is moved, a JSlider object generates a change event (this event occurs
        when there’s a change in the event source, such as the nob is moved). To process
        change events, we must register change event listeners to a JSlider event source
        object. The class that implements the ChangeListener interface must define a
        method called stateChanged, whose parameter is an instance of ChangeEvent. For
        this program, whenever a change event is generated, we read the value from each
        slider and set the background of a panel to a designated color.
        */

        Ch14SliderSample sliderSample = new Ch14SliderSample();
        sliderSample.setVisible(true);
    }
}

class Ch14SliderSample extends JFrame implements ChangeListener {
    // data members
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 250;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private static final int MIN_COLOR = 0;
    private static final int MAX_COLOR = 255;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;
    private JPanel colorPanel;

    // constructors
    public Ch14SliderSample() {
        Container contentPane;
        JPanel sliderPanel;

        //set the frame properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Program Ch14JListSample");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());

        //create and place a JList
        sliderPanel = new JPanel(new FlowLayout());
        sliderPanel.setBorder(BorderFactory.createTitledBorder("RGB Color Selection"));

        redSlider = createSlider(MAX_COLOR);
        greenSlider = createSlider(MAX_COLOR);
        blueSlider = createSlider(MAX_COLOR);

        sliderPanel.add(redSlider);
        sliderPanel.add(greenSlider);
        sliderPanel.add(blueSlider);

        colorPanel = new JPanel( );
        colorPanel.setBackground(Color.white);
        colorPanel.setBorder(BorderFactory.createLoweredBevelBorder());

        contentPane.add(colorPanel, BorderLayout.CENTER);
        contentPane.add(sliderPanel, BorderLayout.WEST);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void stateChanged(ChangeEvent event) {
        int R, G, B;
        R = redSlider.getValue();
        G = greenSlider.getValue();
        B = blueSlider.getValue();
        colorPanel.setBackground(new Color(R, G, B));
    }

    private JSlider createSlider(int value) {
        JSlider slider = new JSlider();

        slider.setOrientation(JSlider.VERTICAL);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinimum(MIN_COLOR);
        slider.setMaximum(MAX_COLOR);
        slider.setValue(value);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(25);
        slider.addChangeListener(this);

        return slider;
    }
}