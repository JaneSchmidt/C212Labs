import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BlackJackPlayer {
    static int[] handTotals = new int[2];
    static boolean bust = false;
    static JLabel totalsLabel = new JLabel();
    static JButton hit = new JButton("Hit");
    static JButton stay = new JButton("Stay");


    static class HitButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Random rand = new Random();
            int temp, ace, faceCard, random;

            /* I tried to make the odds of getting a face card
             * or ace but idk if its correct
             * ace - 1/13
             * face card - 1/4ish
             */
            random = rand.nextInt(9);
            random++;
            ace = rand.nextInt(13);
            faceCard = rand.nextInt(4);
            if(ace == 0){
                temp = handTotals[0];
                handTotals[0] = temp + 1;
                temp = handTotals[1];
                handTotals[1] = temp + 11;
                totalsLabel.setText("Players Totals: " + handTotals[0] + ", " + handTotals[1]);
            }
            else if(faceCard == 0){
                temp = handTotals[0];
                handTotals[0] = temp + 10;
                temp = handTotals[1];
                handTotals[1] = temp + 10;
                if(handTotals[0] == handTotals[1]) {
                    totalsLabel.setText("Players Total: " + handTotals[0]);
                }
                else{
                    totalsLabel.setText("Players Totals: " + handTotals[0] + ", " + handTotals[1]);
                }
            }
            else {
                temp = handTotals[0];
                handTotals[0] = temp + random;
                temp = handTotals[1];
                handTotals[1] = temp + random;
                if(handTotals[0] == handTotals[1]) {
                    totalsLabel.setText("Players Total: " + handTotals[0]);
                }
                else{
                    totalsLabel.setText("Players Totals: " + handTotals[0] + ", " + handTotals[1]);
                }
            }

            if(handTotals[0] > 21 && handTotals[1] > 21){
                bust = true;
                totalsLabel.setText("Bust!");
                hit.setEnabled(false);
                stay.setEnabled(false);
            }

        }
    }
    static class StayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /*when action performed disable both buttons */
            hit.setEnabled(false);
            stay.setEnabled(false);
        }
    }

    public static void main(String[] args){
        Random rand = new Random();
        int random = rand.nextInt(9);
        random++;
        handTotals[0] = random;
        handTotals[1] = random;

        JFrame frame = new JFrame("Black Jack Game");
        JPanel mainPanel = new JPanel();
        JPanel statusPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        mainPanel.add(statusPanel);
        mainPanel.add(buttonsPanel);

        random = rand.nextInt(8);
        random = random + 2;
        JLabel dealerLabel = new JLabel("Dealer has " + random + " + ???");
        statusPanel.add(dealerLabel);
        totalsLabel.setText("Players Total: " + handTotals[0]);
        statusPanel.add(totalsLabel);

        ActionListener hitListener = new HitButtonListener();
        ActionListener stayListener = new StayButtonListener();
        hit.addActionListener(hitListener);
        stay.addActionListener(stayListener);
        buttonsPanel.add(hit);
        buttonsPanel.add(stay);

        frame.add(mainPanel);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
