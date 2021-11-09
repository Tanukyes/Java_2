package HW1;

public class Robot implements Runnable, Jumpable {
    private String name;
    private int maxRun;
    private int maxJump;
    private boolean isStopped = false;

    Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean jump(int hight) {
        if (hight <= maxJump) {
            System.out.println(name + " прыгнул через препядствие высотой: " + hight);
            return true;
        } else {
            System.out.println(name + " не прыгнул через препядствие высотой: " + hight);
            isStopped = true;
            return false;
        }
    }

    @Override
    public boolean run(int lenght) {
        if (lenght <= maxRun) {
            System.out.println(name + " пробежал препядствие длиной: " + lenght);
            return true;
        } else {
            System.out.println(name + " не пробежал препядствие длиной: " + lenght);
            isStopped = true;
            return false;
        }
    }

    @Override
    public boolean isStopped() {
        return isStopped;
    }

}
