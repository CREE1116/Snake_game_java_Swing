package Process;

import java.util.Vector;

import Frame.MainPanel;
import Global.Constance.Distance;
import Global.Constance.Entity;

public class Snake implements Runnable {
    private Vector<Entity> SnakeBody;
    final private int Delay = 150;
    private MainPanel mainPanel;
    private boolean addBoodyBoolean = false;

    public Snake() {
        SnakeBody = new Vector<>();
    }

    public void Start(int rows, int cols) {
        Entity temp = Entity.eSankeHead;
        temp.setLocate(rows, cols);
        temp.setDistance(Distance.RIGHT);
        mainPanel.setHead(rows, cols);
        SnakeBody.add(temp);
    }

    public void ChangeDistance(Distance distance) {
        SnakeBody.get(0).setDistance(distance);
    }

    private void move() throws Exception {
        Entity head = SnakeBody.get(0);
        int x = head.getX();
        int y = head.getY();
        mainPanel.setDefault(x, y);
        head.move();
        mainPanel.setHead(head.getX(), head.getY());
        if (SnakeBody.size() < 2)
            return;
        for (int i = 1; i < SnakeBody.size(); i++) {
            Entity tempEntity = SnakeBody.get(i);
            int tempX = tempEntity.getX();
            int tempY = tempEntity.getY();
            mainPanel.setDefault(tempX, tempY);
            tempEntity.setLocate(x, y);
            SnakeBody.set(i, tempEntity);
            mainPanel.setBody(x, y);
            x = tempX;
            y = tempY;
        }
        crush(head.getX(), head.getY());
    }

    public Distance getCurrentDistance() {
        return SnakeBody.get(0).getDistance();
    }

    public void addBody() {
        Entity temp = Entity.eSankeBody;
        temp.setLocate(SnakeBody.get(SnakeBody.size() - 1).getX(),
                SnakeBody.get(SnakeBody.size() - 1).getY());
        SnakeBody.add(temp);
        showList(SnakeBody);
    }

    private void showList(Vector<Entity> vector) {
        System.out.print("<");
        for (Entity temp : vector)
            System.out.print(temp.OutStirng() + " ");
        System.out.println(">");
    }

    public void addBodyBoolean() {
        this.addBoodyBoolean = true;
    }

    public void initialize(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private void crush(int x, int y) throws Exception {
        for (Entity temp : SnakeBody) {
            if (temp.equals(Entity.eSankeBody) && temp.checkLocation(x, y)) {
                mainPanel.gameOverAction();
                throw new Exception();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {// 딜레이 만큼 기다렸다가 입력된방향으로 이동
                Thread.sleep(Delay);
                move();
                if (addBoodyBoolean) {
                    addBody();
                    this.addBoodyBoolean = false;
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
