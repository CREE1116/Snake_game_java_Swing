package Frame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import Global.Constance.Direction;
import Process.Food;
import Process.Snake;

import java.awt.GridLayout;

public class MainPanel extends JPanel {
    private GridLayout layout;
    private CardPanel cardPanel;
    private int Size,Delay;
    private Snake snake;
    private Food food;
    private JPanel[][] Map;
    private Color Default = new Color(50,50,50);
    private Color HeadColor, BodyColor, FoodColor;
    private boolean isRunning;

    public MainPanel() {
        super(true);
        Size = 35;
        isRunning = false;
        Delay = 100;
        MapSetting();
        ColorsSetting();
    }
    public MainPanel(int Size, int Delay) {
        super(true);
        this.Size = Size;
        isRunning = false;
        this.Delay = Delay;
        MapSetting();
        ColorsSetting();
    }
    private void ColorsSetting(){
        HeadColor = new Color(250,250,250,200);
        BodyColor = new Color(200,200,200,200);
        FoodColor = new Color(200,200,200,220);
        Map[Size/2][Size/2].setBackground(HeadColor);
        this.setBackground(Default);
    }
    public void MapSetting(){
        System.out.println("Size: "+Size);
        layout = new GridLayout(Size, Size);
        this.setLayout(layout);
        addGridPanel(Size, Size);
    } 
    private void runSnake(){
        snake = new Snake();
        snake.initialize(this);
        snake.init(Size, Size,Delay);
        Thread SnakeThread = new Thread(snake);
        SnakeThread.start();
    }
    private void runFood(){
        food = new Food(Size, Size, Delay*30);
        food.initialize(this);
        Thread FoodThread = new Thread(food);
        FoodThread.start();
    }
    private void addGridPanel(int rows, int cols) {
        Map = new JPanel[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Map[i][j] = new JPanel();
                Map[i][j].setBorder(new TitledBorder(new MatteBorder(0,0,1,1,new Color(25,25,25,100))));
                Map[i][j].setBackground(Default);
                this.add(Map[i][j]);
            }
        }
    }
    public void keyEventHandler(int keyCode) {
        if(!isRunning){
            runSnake();
            runFood();
            isRunning = true;
        }
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
    public int getScore(){
        return snake.getSize();
    }
    public void gameOverAction(){
        food.ending();
        cardPanel.gameOverAction();
    }
    public void setHead(int rows, int cols) {
        try {
            Map[cols][rows].setBackground(HeadColor);
            if(food.eatFood(rows,cols))
                snake.eatFood();
        } catch (ArrayIndexOutOfBoundsException e) {
            this.gameOverAction();
        }
    }
    public void setBody(int rows, int cols) {
        Map[cols][rows].setBackground(BodyColor);
    }

    public void setDefault(int rows, int cols) {
        Map[cols][rows].setBackground(Default);
    }

    public void setFood(int rows, int cols) {
        Map[cols][rows].setBackground(FoodColor);
    }

    public void initialize(CardPanel cardPanel) {
        this.cardPanel = cardPanel;
    }
}
