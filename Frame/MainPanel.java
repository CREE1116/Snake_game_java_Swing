package Frame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import Global.Constance.Distance;

import Process.Snake;

import java.awt.GridLayout;

public class MainPanel extends JPanel {
    private GridLayout layout;
    private MainFrame mainFrame;
    private int rows, cols;
    private Snake snake;
    private JPanel[][] Map;

    public MainPanel() {
        rows = 25;
        cols = 25;
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(new TitledBorder(new LineBorder(Color.white)));
        layout = new GridLayout(rows, cols);
        this.setLayout(layout);
        addGridPanel(rows, cols);
        // this.addKeyListener(new MyKeyListener());
        snake = new Snake();
        snake.initialize(this);
        snake.Start(5, 0);
        Thread SnakeThread = new Thread(snake);
        SnakeThread.start();
        System.out.println("hi");
    }

    private void addGridPanel(int rows, int cols) {
        Map = new JPanel[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Map[i][j] = new JPanel();
                Map[i][j].setBorder(new TitledBorder(new LineBorder(Color.white)));
                Map[i][j].setBackground(Color.gray);
                this.add(Map[i][j]);
            }
        }
    }

    public void keyEventHandler(int keyCode) {
        switch (keyCode) {
            case 37:
                if (!snake.getCurrentDistance().equals(Distance.RIGHT))
                    snake.ChangeDistance(Distance.LEFT);
                break;
            case 38:
                if (!snake.getCurrentDistance().equals(Distance.DOWN))
                    snake.ChangeDistance(Distance.UP);
                break;
            case 39:
                if (!snake.getCurrentDistance().equals(Distance.LEFT))
                    snake.ChangeDistance(Distance.RIGHT);
                break;
            case 40:
                if (!snake.getCurrentDistance().equals(Distance.UP))
                    snake.ChangeDistance(Distance.DOWN);
                break;
            case 32:
                snake.addBodyBoolean();
                break;
            default:
                ;
                break;
        }
    }

    public void gameOverAction() {
        mainFrame.gameOverAction();
    }

    public void setHead(int rows, int cols) {
        try {
            Map[cols][rows].setBackground(Color.red);
            Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.white)));
        } catch (ArrayIndexOutOfBoundsException e) {
            this.gameOverAction();
        }
    }

    public void setBody(int rows, int cols) {
        Map[cols][rows].setBackground(Color.green);
        Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.white)));
    }

    public void setDefault(int rows, int cols) {
        Map[cols][rows].setBackground(Color.gray);
        Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.white)));
    }

    public void setFood(int rows, int cols) {
        Map[cols][rows].setBackground(Color.white);
        Map[cols][rows].setBorder(new TitledBorder(new LineBorder(Color.black)));
    }

    public void initialize(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
