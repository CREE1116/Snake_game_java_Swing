package Entity;

import Global.Location;
import Global.Constance.Type;

public abstract class Entity {
    protected Type entityType;
    protected Location location;
    public Entity (Type entityType,Location location){
        this.location = location;
        this.entityType = entityType;
    }
    public boolean checkLocation(Location location){
        return this.location.equals(location);
    }
    public Type Type(){
        return this.entityType;
    }
    public Location getLocation(){
        return this.location;
    }
    public void setLocation (Location location){
        this.location = location;
    }

    
}
