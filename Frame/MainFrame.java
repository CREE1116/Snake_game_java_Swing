package Frame;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	private CardPanel cardPanel;


	public MainFrame() {
		this.setSize(500, 500);
		this.setResizable(false);
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cardPanel = new CardPanel();
		cardPanel.setVisible(true);
		initialize();
		this.add(cardPanel);
		this.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		cardPanel.keyEventHandler(e.getKeyCode());
	}

	public void initialize() {
		cardPanel.initialize(this);
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
