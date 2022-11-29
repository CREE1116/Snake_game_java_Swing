package Global;

public class Location implements Cloneable{
    private int x,y;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Location location){
        return location.getX() == this.x && location.getY() == this.y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Location addLocation(int x, int y){
        this.x= this.x+x;
        this.y= this.y+y;
        return this;
    }
    public Location Clone(){
        try {
            return (Location) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String toString(){
        return "[ "+this.x+" , "+this.y+" ]";
    }
}
