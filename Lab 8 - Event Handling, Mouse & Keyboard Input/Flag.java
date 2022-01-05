import javax.swing.*;
import java.awt.*;

public class Flag extends JComponent {
    public void paintComponent(Graphics g){
        g.setColor(Color.red);
        g.fillRect(0, 0, 500, 100);
        g.setColor(Color.yellow);
        g.fillRect(0, 100, 500, 100);
        g.setColor(Color.green);
        g.fillRect(0, 200, 500, 100);
        g.setColor(Color.black);
        g.drawOval(210, 110, 80, 80);
        g.drawOval(215, 115, 70, 70);
        g.drawOval(220, 120, 60, 60);
        g.drawOval(225, 125, 50, 50);
        g.drawOval(230, 130, 40, 40);
        g.drawOval(235, 135, 30, 30);
        g.drawOval(240, 140, 20, 20);
        g.drawOval(245, 145, 10, 10);
    }
}
