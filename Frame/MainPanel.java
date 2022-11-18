package Frame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

import Global.Constance.Distance;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Process.Snake;

import java.awt.GridLayout;

public class MainPanel extends JPanel {
    private GridLayout layout;
    private int rows,cols;
    private Snake snake;
    private JPanel [][]Map;
    public MainPanel (){
        rows = 25;cols = 25;
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(new TitledBorder(new LineBorder(Color.white)));
        layout = new GridLayout(rows,cols);
        this.setLayout(layout);
        addGridPanel(rows,cols);
        this.addMouseListener(new MyKeyListener());
        snake = new Snake();
        snake.initialize(this);
        snake.Start(5,0);
        Thread SnakeThread = new Thread(snake);
        SnakeThread.start();
        System.out.println("hi");
    }
    private void addGridPanel(int rows, int cols){
        Map = new JPanel[cols][rows];
        for(int i = 0 ; i<rows;i++){
            for(int j = 0; j<cols;j++){
                Map[i][j] = new JPanel();
                Map[i][j].setBorder(new TitledBorder(new LineBorder(Color.white)));
                Map[i][j].setBackground(Color.gray);
                this.add(Map[i][j]);
            }
        }
    }
    public void setHead(int rows, int cols){
        Map[cols][rows].setBackground(Color.red);
        Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.white)));
    }
    public void setBody(int rows, int cols){
        Map[cols][rows].setBackground(Color.green);
        Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.white)));
    }
    public void setDefault(int rows, int cols){
        Map[cols][rows].setBackground(Color.gray);
        Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.white)));
    }
    public void setFood(int rows, int cols){
        Map[cols][rows].setBackground(Color.white);
        Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.black)));
    }
/**     
    class MyKeyListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent ke) {}
        
        @Override
        public void keyPressed(KeyEvent ke) {//방향설정 키 리스너
            System.out.println("----"+ke.getKeyCode());
            switch(ke.getKeyCode()){//입력된 키에 따른 방향 설정
                case KeyEvent.VK_LEFT:
                    snake.ChangeDistance(Distance.LEFT);
                    System.out.println("LEFT");
                break;
                case KeyEvent.VK_RIGHT:
                    snake.ChangeDistance(Distance.RIGHT);
                    System.out.println("RIGHT");
                break;
                case KeyEvent.VK_UP:
                    snake.ChangeDistance(Distance.UP);
                    System.out.println("UP");
                break;
                case KeyEvent.VK_DOWN:
                    snake.ChangeDistance(Distance.DOWN);
                    System.out.println("DOWN");
                break;
            }
        }
        
        @Override
        public void keyReleased(KeyEvent ke) {}
    }
    */
    private class MyKeyListener implements MouseInputListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(e.getClickCount()==1) {
                    snake.addBodyBoolean();
				}if(e.getClickCount()==2) {
					snake.ChangeDistance(Distance.DOWN);
				}
			}
		}

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseDragged(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    }
}

