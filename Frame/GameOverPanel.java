package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel implements ActionListener{
    private CardPanel cardPanel;
    private JLabel score;
    public GameOverPanel() {
        this.setName("GameOverPanel");
        JLabel label = new JLabel("Game Over");
        this.add(label);
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        this.add(restartButton);
    }   
    public void initialize(CardPanel cardPanel){
        this.cardPanel = cardPanel;
    }
    public void setScore(int score){
        if(this.score != null){
            this.remove(this.score);
        }
        this.score = new JLabel("Your Score is: " + score);
        this.add(this.score);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        cardPanel.SettingAction();
    }
    
}