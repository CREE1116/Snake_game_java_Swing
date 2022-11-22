package Frame;

import javax.swing.JPanel;

import java.awt.CardLayout;


public class CardPanel extends JPanel {
    private MainFrame mainFrame;
    private CardLayout cardLayout;
    private MainPanel mainPanel;
    private GameOverPanel gameOverPanel;
    private SettingPanel settingPanel;
    private int Score;
    
    public CardPanel(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        addSettingPanel();
        addGameOverPanel();
    }
    public void addGameOverPanel(){
		this.gameOverPanel = new GameOverPanel();
		gameOverPanel.setVisible(true);
		this.add("gameOver",gameOverPanel);
	}
    public void addSettingPanel(){
        this.settingPanel = new SettingPanel();
        settingPanel.setVisible(true);
        this.add("setting",settingPanel);
    }

    public void keyEventHandler(int keyCode){
        mainPanel.keyEventHandler(keyCode);
    }
    public void gameOverAction(){
        this.Score = mainPanel.getScore();
        gameOverPanel.setScore(Score);
        cardLayout.show(this, "gameOver");
        System.out.println("over");
    }
    public void SettingAction(){
        cardLayout.show(this, "setting");
    }
    public void Restart(int Size, int Delay){
        if(mainPanel != null)
            this.remove(mainPanel);        
        this.mainPanel = new MainPanel(Size,Delay);
        mainPanel.setVisible(true);
        this.add("main",mainPanel);
        mainPanel.initialize(this);
        cardLayout.show(this, "main");
        mainFrame.requestFocus();
    }

    public void initialize(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        gameOverPanel.initialize(this);
        settingPanel.initialize(this);
    }
}