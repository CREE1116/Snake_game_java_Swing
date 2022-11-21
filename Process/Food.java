package Process;

import java.util.Vector;

import Entity.FoodEntity;
import Frame.MainPanel;
import Global.Location;

public class Food implements Runnable {
    private int Delay;
    private MainPanel mainPanel;
    private Vector<FoodEntity> FoodMap;
    private int rows,cols;
    public Food(int rows, int cols,int Delay){
        this.rows = rows;
        this.cols = cols;
        this.Delay = Delay;
        FoodMap = new Vector<>();

    }
    public boolean eatFood(int x, int y){
        for(FoodEntity food : FoodMap){
            if(food.getLocation().equals(new Location(x,y))) {
                FoodMap.remove(food);
                return true;
            }
        }
        return false;
    }

    private void setPanelFood(FoodEntity entity){
        mainPanel.setFood(entity.getLocation().getX(), entity.getLocation().getY());
    }
    private void spread(){
        Location location = new Location(randomInt(rows),randomInt(cols));
        FoodEntity entity = new FoodEntity(location);
        System.out.println("Food!!!!~~~~~"+entity.getLocation()+" .  x,y = "+rows+", "+cols);
        System.out.println((int)(Math.random()*10));
        setPanelFood(entity);
        FoodMap.add(entity);
    }
    private int randomInt(int max){
        return (int)(Math.random()*(max-1));
    }
    @Override
    public void run() {
        while (true) {
            try {// 딜레이 만큼 기다렸다가 입력된방향으로 이동
                Thread.sleep(Delay+(int)((Math.random()*Delay/10)-Delay/20));
                if(FoodMap.size()<5)
                    spread();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
    public void initialize(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

}