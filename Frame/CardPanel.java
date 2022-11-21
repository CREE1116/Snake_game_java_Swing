package Frame;

import javax.swing.JPanel;


import java.awt.CardLayout;


public class CardPanel extends JPanel {
    private MainFrame mainFrame;
    private CardLayout cardLayout;
    private MainPanel mainPanel;
    private GameOverPanel gameOverPanel;
    
    public CardPanel(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        addMainPanel();
        addGameOverPanel();
    }
    public void addMainPanel(){
		this.mainPanel = new MainPanel(true);
		mainPanel.setVisible(true);
		this.add("main",mainPanel);
	}
    public void addGameOverPanel(){
		this.gameOverPanel = new GameOverPanel();
		gameOverPanel.setVisible(true);
		this.add("gameOver",gameOverPanel);
	}

    public void keyEventHandler(int keyCode){
        mainPanel.keyEventHandler(keyCode);
    }
    
    public void gameOverAction(){
        cardLayout.show(this, "gameOver");
        System.out.println("over");
    }
    public void Restart(){
        this.remove(mainPanel);        
        this.mainPanel = new MainPanel(true);
        mainPanel.setVisible(true);
        this.add("main",mainPanel);
        mainPanel.initialize(this);
        cardLayout.show(this, "main");
        mainFrame.requestFocus();
    }

    public void initialize(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        mainPanel.initialize(this);
        gameOverPanel.initialize(this);
    }
}