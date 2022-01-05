import javax.swing.*;
import java.awt.*;

public class KeyListenerDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Interaction");
        /* end program when the user closes the JFrame */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel keyPanel = new JPanel();
        frame.add(keyPanel);
        /* register your mouseListenerImplementation to the JPanel */
        KeyListenerImplementation implement = new KeyListenerImplementation();
        keyPanel.add(implement);

        frame.pack();
        frame.setVisible(true);
    }
}
