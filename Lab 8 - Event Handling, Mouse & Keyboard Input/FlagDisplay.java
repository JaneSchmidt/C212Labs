import javax.swing.*;

public class FlagDisplay {

    public static void main(String[] args){
        JFrame flagFrame = new JFrame("Flag of Jane Land");
        flagFrame.setSize(500, 325);
        Flag JComponent = new Flag();
        flagFrame.add(JComponent);
        flagFrame.setVisible(true);
        flagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
