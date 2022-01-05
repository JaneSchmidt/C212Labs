import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerImplementation extends JPanel{
    private int counter;

    public KeyListenerImplementation(){
        addKeyListener(new ListeningToKeys());
        setBackground(Color.green);
        setPreferredSize(new Dimension(500, 300));
        setFocusable(true);
        requestFocusInWindow();
    }

    private class ListeningToKeys implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            char keyPressed = e.getKeyChar();
            if(keyPressed == 'e'){
                System.exit(0);
            }
            else if(keyPressed == 'h'){
                System.out.println("Hello World");
            }
            else{
                System.out.println(keyPressed);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            counter++;
            System.out.println("You have pressed the keyboard " + counter + " number of times");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            char keyPressed = e.getKeyChar();
            int asciiValue = (int)keyPressed;
            System.out.println("Key pressed: " + keyPressed + " Ascii value: " + asciiValue);
        }
    }

}
