# Snake_game_java_Swing


## 자바와 스윙을 이용한 고전게임 스네이크를 구현

### 맵 구현
<img width="484" alt="스크린샷 2022-11-21 오전 9 05 19" src="https://user-images.githubusercontent.com/104889277/202933965-a6b10567-fa16-44ee-a329-cd2a7b98e128.png">

- 25*25형태의 맵, 그리드 레이아웃을 이용해 2차원 배열로 배열된 JPanel의 색을 바꿈으로 표현
```java
layout = new GridLayout(rows, cols);
this.setLayout(layout);
addGridPanel(rows, cols);
```

```java
private void addGridPanel(int rows, int cols) {
        Map = new JPanel[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Map[i][j] = new JPanel();
                Map[i][j].setBorder(new TitledBorder(new LineBorder(Color.white)));
                Map[i][j].setBackground(Color.gray);
                this.add(Map[i][j]);
            }
        }
    }
```
> 2차원 Jpanel배열인 Map을 통해 원하는 좌표의 Jpanel의 상태를 변경시킨다.
> rows와 cols 바뀌만 알아서 맵을 생성할수 있기 때문에 추후 인게임에서 시작하기 전에 맵 크기를 변경 가능하게 만들 예정

### 뱀의 몸체 구현

- 각각의 정보는 모두 Entity로 명명된 enum에 저장한다.
 ```java
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
```
    
- move() 메소드를 통해 저장된 direction enum값 만큼 좌표를 변경한다.
    
    
```java
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
```
    
