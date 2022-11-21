package Global;

public class Constance {
    public enum Entity {
        eSankeBody("Body"),
        eSankeHead("Head"),
        eFood("Food"),
        eDefault("Default");

        private Location location;
        private String name;
        private Distance distance;

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

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public Distance getDistance() {
            return this.distance;
        }

        public Entity move() {
            this.location.addLocation(distance.getXDistance(), distance.getYDistance());
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

    public enum Distance {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0),
        STOP(0,0);

        private int cols, rows;

        Distance(int cols, int rows) {
            this.cols = cols;
            this.rows = rows;
        }

        public int getXDistance() {
            return this.cols;
        }

        public int getYDistance() {
            return this.rows;
        }
    }

}
