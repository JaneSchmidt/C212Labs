import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;

public class MouseListenerImplementation extends JPanel {
    private int counter;

    public MouseListenerImplementation() {
        addMouseListener(new ListeningToMouse());
        setBackground(Color.blue);
        setPreferredSize(new Dimension(500, 300));
    }

    private class ListeningToMouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {System.out.println("Java is the bestest");}

        @Override
        public void mousePressed(MouseEvent e) {
            counter++;
            System.out.println("Number of events: " + counter);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int x, y;
            x = e.getX();
            y = e.getY();
            /*print the (x,y) coordinates to the console in the form */
            System.out.println("(" + x + ", " + y + ") mouse was released");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}