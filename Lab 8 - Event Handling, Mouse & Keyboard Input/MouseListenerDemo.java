import javax.swing.*;

public class MouseListenerDemo {

    public static void main(String[] args){
        JFrame frame = new JFrame("Mouse Interaction");
        /* end program when the user closes the JFrame */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mousePanel = new JPanel();
        frame.add(mousePanel);
        /* register your mouseListenerImplementation to the JPanel */
        MouseListenerImplementation implement = new MouseListenerImplementation();
        mousePanel.add(implement);

        /* display the frame to the user
         * .pack() sizes the frame so its contents are at/above preferred sizes */
        frame.setVisible(true);
        frame.pack();
        /* key listener:
         * newPanel.setFocusable(true); */
    }

}
