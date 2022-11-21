package Global;

public class Constance {
    public enum Entity {
        eSankeBody("Body"),
        eSankeHead("Head"),
        eFood("Food"),
        eDefault("Default");

        private Location location;
        private String name;
        private Direction direction;

        Entity(String name) {
            this.name = name;
        }

        public Location geLocation(){
            return this.location;
        }

        public Entity setLocation(int cols, int rows) {
            this.location = new Location(cols, rows);
            return this;
        }
        public Entity setLocation(Location location) {
            this.location = location;
            return this;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public Direction getDistance() {
            return this.direction;
        }

        public Entity move() {
            this.location.addLocation(direction.getX(), direction.getY());
            return this;
        }

        public boolean checkLocation(int x, int y) {
            return this.location.equals(new Location(x, y));
        }
        public boolean checkLocation(Location location){
            return this.location.equals(location);
        }

        public String OutStirng() {
            return this.name + "[" + location.getX() + " , " + location.getY() + "]";
        }
    }

    public enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0),
        STOP(0,0);

        private int cols, rows;

        Direction(int cols, int rows) {
            this.cols = cols;
            this.rows = rows;
        }

        public int getX() {
            return this.cols;
        }

        public int getY() {
            return this.rows;
        }
    }

}
