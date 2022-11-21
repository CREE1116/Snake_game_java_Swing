package Frame;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	private MainPanel mainPanel;
	private GameOverPanel gameOverPanel;

	public MainFrame() {
		this.setSize(500, 500);
		this.setResizable(false);
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.gameOverPanel = new GameOverPanel();
		gameOverPanel.setVisible(false);
		this.add(gameOverPanel);
		this.mainPanel = new MainPanel();
		mainPanel.setVisible(true);
		this.add(mainPanel);
		this.addKeyListener(this);
	}

	public void gameOverAction() {
		gameOverPanel.setVisible(true);
		mainPanel.setVisible(false);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		mainPanel.keyEventHandler(e.getKeyCode());
	}

	public void initialize() {
		mainPanel.initialize(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
