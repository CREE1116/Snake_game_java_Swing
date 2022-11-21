package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel implements ActionListener{
    private CardPanel cardPanel;
    public GameOverPanel() {
        this.setName("GameOverPanel");
        JLabel label = new JLabel("Game Over");
        this.setBackground(Color.red);
        this.add(label);
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        this.add(restartButton);
    }   
    public void initialize(CardPanel cardPanel){
        this.cardPanel = cardPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        cardPanel.Restart();
    }
    
}