package Global;

public class Constance {
    public enum Entity {
        eSankeBody("Body"),
        eSankeHead("Head"),
        eFood("Food");

        private int cols, rows;
        private String name;
        private Distance distance;

        Entity(String name) {
            this.name = name;
        }

        public int getX() {
            return this.cols;
        }

        public int getY() {
            return this.rows;
        }

        public void setLocate(int cols, int rows) {
            this.cols = cols;
            this.rows = rows;
        }

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public Distance getDistance() {
            return this.distance;
        }

        public void move() {
            this.setLocate(this.cols + distance.getXDistance(), this.rows + distance.getYDistance());
        }

        public boolean checkLocation(int x, int y) {
            if (this.cols == x && this.rows == y)
                return true;
            return false;
        }

        public String OutStirng() {
            return this.name + "[" + cols + " , " + rows + "]";
        }
    }

    public enum Distance {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

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
