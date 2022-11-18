package Process;

import java.util.Vector;

import Frame.MainPanel;
import Global.Constance.Distance;
import Global.Constance.Entity;

public class Snake implements Runnable{
    private Vector<Entity> SnakeBody;
    final private int Delay = 500;
    private MainPanel mainPanel;
    private boolean addBoodyBoolean = false;

    public Snake(){
        SnakeBody = new Vector<>();
    }
    public void Start(int rows,int cols){
        Entity temp = Entity.eSankeHead;
        temp.setLocate(rows,cols);
        temp.setDistance(Distance.RIGHT);
        mainPanel.setHead(rows,cols);
        SnakeBody.add(temp);
    }
    public void ChangeDistance(Distance distance){
        SnakeBody.get(0).setDistance(distance);
        System.out.println("Distance Changed!");
    }

    private void move(){
        Entity head = SnakeBody.get(0);
        int x = head.getX();
        int y = head.getY();
        mainPanel.setDefault(x,y);
        head.move();
        mainPanel.setHead(head.getX(), head.getY());
        if(SnakeBody.size() < 2)return;
        for(Entity tempEntity : SnakeBody){
            if(!tempEntity.equals(Entity.eSankeHead)){
            int tempX = tempEntity.getX();
            int tempY = tempEntity.getY();
            mainPanel.setDefault(tempX, tempY);
            tempEntity.setLocate(x, y);
            mainPanel.setBody(x, y);
            x = tempX;
            y = tempY;
        }
    }
        }

        

    public void addBody(){
        Entity temp = Entity.eSankeBody;
        SnakeBody.get(0).getDistance().getXDistance();
        SnakeBody.get(SnakeBody.size()-1).getX();
        SnakeBody.get(SnakeBody.size()-1).getY();
        temp.setLocate(SnakeBody.get(SnakeBody.size()-1).getX()- SnakeBody.get(0).getDistance().getXDistance(),
                        SnakeBody.get(SnakeBody.size()-1).getY()-SnakeBody.get(0).getDistance().getYDistance());
        mainPanel.setBody(temp.getX(), temp.getY());
        SnakeBody.add(temp);
        System.out.println(SnakeBody.toString());
    }
    public void addBodyBoolean(){
        this.addBoodyBoolean =true;
    }

    public void initialize(MainPanel mainPanel){
        this.mainPanel = mainPanel;
    }
    @Override
    public void run(){
        while(true){
            try{//딜레이 만큼 기다렸다가 입력된방향으로 이동
                Thread.sleep(Delay);
                move();
                if(addBoodyBoolean){
                    addBody();
                    addBoodyBoolean = false;
                }
            }
            catch(Exception e){
                return;
            }
        }
    }
}
