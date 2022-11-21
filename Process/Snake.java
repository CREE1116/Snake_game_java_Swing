package Process;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

import Frame.MainPanel;
import Global.Location;
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
        temp.setLocation(rows, cols);
        temp.setDistance(Distance.STOP);
        mainPanel.setHead(rows, cols);
        SnakeBody.add(temp);
    }

    public void ChangeDistance(Distance distance) {
        SnakeBody.get(0).setDistance(distance);
    }

    private void move() throws Exception {
        Location temp = getHead().geLocation().Clone();
        MoveHead();
        if(SnakeBody.size()>1)MoveBody(temp,addBoodyBoolean);
        if(addBoodyBoolean&&SnakeBody.size()==1)addBody(temp);
        if(addBoodyBoolean)addBoodyBoolean=false;
        crush(SnakeBody.get(0).geLocation());
        showList(SnakeBody);
    }

    public Entity getHead() {
        return SnakeBody.get(0);
    }
    public Distance getCurrentDistance(){
        return getHead().getDistance();
    }

    public void addBody(Location tempLocation) {
        Entity temp = Entity.eSankeBody.setLocation(tempLocation.Clone());
        SnakeBody.add(temp);
        setPanelState(temp);

    }

    private void showList(Vector<Entity> vector) {
        System.out.print("<");
        for (Entity temp : vector)
            System.out.print(temp.OutStirng() + ", ");
        System.out.println(">");
    }

    public void addBodyBoolean() {
        this.addBoodyBoolean = true;
    }

    public void initialize(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private void crush(Location location) throws Exception {
        for (Entity temp : SnakeBody) {
            if (temp.equals(Entity.eSankeBody) && temp.checkLocation(location)) {
                mainPanel.gameOverAction();
                throw new Exception();
            }
        }
    }
    private void setPanelState(Entity entity){
        switch (entity){
            case eSankeHead: mainPanel.setHead(entity.geLocation().getX(), entity.geLocation().getY());
                break;
            case eSankeBody: mainPanel.setBody(entity.geLocation().getX(), entity.geLocation().getY());
                break;
            case eFood: mainPanel.setFood(entity.geLocation().getX(), entity.geLocation().getY());
                break;
            case eDefault: mainPanel.setDefault(entity.geLocation().getX(), entity.geLocation().getY());
        }
    }
    private void MoveHead() throws InterruptedException{
        Entity Head = SnakeBody.get(0);
        setPanelState(Entity.eDefault.setLocation(Head.geLocation()));
        Head.move();
        setPanelState(Head);
    }
    private void MoveBody(Location location,boolean addBoodyBoolean) throws InterruptedException{
    if(!addBoodyBoolean){
        setPanelState(Entity.eDefault.setLocation(SnakeBody.get(SnakeBody.size()-1).geLocation().Clone()));
        SnakeBody.remove(SnakeBody.size()-1);
        }
        Entity newEntity = Entity.eSankeBody.setLocation(new Location(location.getX(),location.getY()));
        SnakeBody.add(1,newEntity);
        setPanelState(newEntity);

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
