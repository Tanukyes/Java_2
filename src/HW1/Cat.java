package HW1;

public class Cat implements Runnable, Jumpable {
    private String name;
    private int maxRun;
    private int maxJump;
    private boolean isStopped = false;


    Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean jump(int hight) {
        if (hight <= maxJump) {
            System.out.println("Кот " + name + " прыгнул через препядствие высотой: " + hight);
            return true;
        } else {
            System.out.println("Кот " + name + " не прыгнул через препядствие высотой: " + hight);
            isStopped = true;
            return false;
        }
    }

    @Override
    public boolean run(int lenght) {
        if (lenght <= maxRun) {
            System.out.println("Кот " + name + " пробежал препядствие длиной: " + lenght);
            return true;
        } else {
            System.out.println("Кот " + name + " не пробежал препядствие длиной: " + lenght);
            isStopped = true;
            return false;
        }
    }

    @Override
    public boolean isStopped() {
        return isStopped;
    }

}
