package Process;

import java.util.Vector;

import Entity.BodyEntity;
import Entity.Entity;
import Entity.HeadEntity;
import Frame.MainPanel;
import Global.Location;
import Global.Constance.Direction;

public class Snake implements Runnable {
    private Vector<Entity> SnakeBody;
    private HeadEntity head;
    private int Delay;
    private MainPanel mainPanel;
    private boolean addBoodyBoolean = false;

    public void init(int rows, int cols,int Delay) {
        this.Delay = Delay;
        head = new HeadEntity(new Location(rows/2, cols/2),Direction.STOP);
        this.SnakeBody = new Vector<>();
    }

    public void ChangeDirection(Direction direction) {
        head.setDirection(direction);
    }
    public Direction getCurrentDirection(){
        return this.head.getDirection();
    }

    private void move() throws Exception {
        Location headLocation = head.getLocation().Clone();
        mainPanel.setDefault(headLocation.getX(), headLocation.getY());
        MoveHead();
        MoveBody(headLocation);
        crush(head.getLocation());
    }

    public void addBody(Location tempLocation) {
        SnakeBody.add(new BodyEntity(tempLocation));
    }

    public void eatFood() {
        this.addBoodyBoolean = true;
    }

    public void initialize(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private void crush(Location location) throws Exception {
        for (Entity temp : SnakeBody) {
            if (temp.checkLocation(location)) {
                mainPanel.gameOverAction();
                throw new Exception();
            }
        }
    }
    private void setPanelState(Entity entity){
        switch (entity.Type()){
            case eSankeHead: mainPanel.setHead(entity.getLocation().getX(), entity.getLocation().getY());
                break;
            case eSankeBody: mainPanel.setBody(entity.getLocation().getX(), entity.getLocation().getY());
                break;
            case eDefault: mainPanel.setDefault(entity.getLocation().getX(), entity.getLocation().getY());
            default:
                break;
        }
    }
    private void MoveHead() throws InterruptedException{
        head.move();
        setPanelState(head);
    }
    private void MoveBody(Location location) throws InterruptedException{
        Location temp1Location = location;
        Location temp2Location;
        for(Entity entity : SnakeBody){
            temp2Location = entity.getLocation();
            mainPanel.setDefault(temp2Location.getX(), temp2Location.getY());
            entity.setLocation(temp1Location);
            setPanelState(entity);
            temp1Location = temp2Location;
        }
        System.out.println(head.getLocation());
        if(addBoodyBoolean){
            System.out.println("add!! "+temp1Location);
            addBody(temp1Location);
            addBoodyBoolean = false;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {// 딜레이 만큼 기다렸다가 입력된방향으로 이동
                Thread.sleep(Delay);
                move();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
