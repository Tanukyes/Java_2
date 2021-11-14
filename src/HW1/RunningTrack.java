package HW1;

public class RunningTrack implements Obstacle {
    public int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    public void accept(Runnable runnable) {
        runnable.run(length);
    }
}
