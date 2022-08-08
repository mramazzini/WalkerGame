import java.awt.GraphicsConfiguration;
import java.io.IOException;
import javax.swing.*;

public class Window {

    static GraphicsConfiguration gc;
    private Panel mainPanel;
    public Window() throws IOException {
        JFrame frame= new JFrame(gc);
        mainPanel = new Panel();
        mainPanel.setFocusable(true);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setTitle("GameTest");
        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
