package Frame;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private MainPanel mainPanel;
	
	public MainFrame(){
		this.setSize(500,500);
		this.setResizable(false);
		BorderLayout layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.mainPanel = new MainPanel();
		this.add(mainPanel);

	}
	public void initialize() {
		
	}
	

}
