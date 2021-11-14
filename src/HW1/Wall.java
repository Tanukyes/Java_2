package HW1;

public class Wall implements Obstacle {
    public int hight;

    public Wall(int hight) {
        this.hight = hight;
    }

    public void accept(Jumpable jumpable) {
        jumpable.jump(hight);
    }

}
