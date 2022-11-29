package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SettingPanel extends JPanel{
    private static final ActionListener SettingPanel = null;
    private CardPanel cardPanel;
    private JComboBox SpeedBox;
    private JComboBox SizeBox;
    ButtonListener buttonListener;
    private String[] Speed = {"Slow", "Normal", "Fast","Very Fast"};
    private String[] Size =  {"15","25","35","45","55"};
    public SettingPanel(){
        this.setName("SettingPanel");
        JLabel label = new JLabel("Setting");
        this.setBackground(Color.lightGray);
        this.add(label);
        SpeedBox = new JComboBox(Speed);
        SizeBox = new JComboBox(Size);
        SpeedBox.setSelectedIndex(1);
        SizeBox.setSelectedIndex(1);
        this.add(SpeedBox);
        this.add(SizeBox);
        JButton startButton = new JButton("Start");
        buttonListener = new ButtonListener();
        startButton.addActionListener(buttonListener);
        this.add(startButton);
    }
    public void initialize(CardPanel cardPanel){
        this.cardPanel = cardPanel;
    }
    public int SpeedSetting(){
        switch (SpeedBox.getSelectedIndex()){
            case 0:
                return 200;
            case 1:
                return 120;
            case 2:
                return 80;
            case 3:
                return 50;
            default:
                return 150;
        }
    }
    public int SizeSetting(){
        switch (SizeBox.getSelectedIndex()){
            case 0:
                return 15;
            case 1:
                return 25;
            case 2:
                return 35;
            case 3:
                return 45;
            case 4:
                return 55;
            default:
                return 25;
        }
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int Speed = SpeedSetting();
            int Size = SizeSetting();
            System.out.println("speed: "+Speed+" size: "+Size);
            cardPanel.Restart(Size,Speed);
        }
    }
   
    
    
    
}