package Frame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import Global.Constance.Direction;
import Process.Food;
import Process.Snake;

import java.awt.GridLayout;

public class MainPanel extends JPanel {
    private GridLayout layout;
    private MainFrame mainFrame;
    private int rows, cols;
    private Snake snake;
    private Food food;
    private JPanel[][] Map;

    public MainPanel() {
        rows = 35;
        cols = 35;
        layout = new GridLayout(rows, cols);
        this.setLayout(layout);
        addGridPanel(rows, cols);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(new TitledBorder(new LineBorder(Color.white)));
        snake = new Snake();
        snake.initialize(this);
        snake.Start(rows, cols,100);
        food = new Food(rows, cols, 2000);
        food.initialize(this);
        Thread SnakeThread = new Thread(snake);
        Thread FoodThread = new Thread(food);
        SnakeThread.start();
        FoodThread.start();
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
                if (!snake.getCurrentDirection().equals(Direction.RIGHT))
                    snake.ChangeDirection(Direction.LEFT);
                break;
            case 38:
                if (!snake.getCurrentDirection().equals(Direction.DOWN))
                    snake.ChangeDirection(Direction.UP);
                break;
            case 39:
                if (!snake.getCurrentDirection().equals(Direction.LEFT))
                    snake.ChangeDirection(Direction.RIGHT);
                break;
            case 40:
                if (!snake.getCurrentDirection().equals(Direction.UP))
                    snake.ChangeDirection(Direction.DOWN);
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
            if(food.eatFood(rows,cols))
                snake.eatFood();
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
