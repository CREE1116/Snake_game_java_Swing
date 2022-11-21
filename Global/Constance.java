package Global;

public class Constance {
    public enum Type {
        eSankeBody(),
        eSankeHead(),
        eFood(),
        eDefault();

        private Location location;
        private Direction direction;

        public Location geLocation(){
            return this.location;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public Direction getDirection() {
            return this.direction;
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
