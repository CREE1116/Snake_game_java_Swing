package Entity;

import Global.Location;
import Global.Constance.Direction;

public class HeadEntity extends Entity{
    private Direction direction;
    public HeadEntity(Location location,Direction direction) {
        super(Global.Constance.Type.eSankeHead, location);
        this.direction = direction;
    }
    public Location move(){
        location.addLocation(direction.getX(), direction.getY());
        return location;
    }
    public HeadEntity setDirection(Direction direction){
        this.direction = direction;
        return this;
    }
    public Direction getDirection(){
        return this.direction;
    }
    
}
