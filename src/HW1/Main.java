package HW1;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[]{
                new Human("Max", 10, 5),
                new Cat("Barsik", 100, 20),
                new Robot("M1N32", 200, 50),
        };
        Obstacle[] obstacles = new Obstacle[]{
                new RunningTrack(5),
                new Wall(2),
                new Wall(3),
                new RunningTrack(50),
                new RunningTrack(100),
                new Wall(25),
                new RunningTrack(49),
                new Wall(199)
        };
        for (Obstacle obstacle : obstacles) {
            for (Participant participant : participants) {
                if (!participant.isStopped()) {
                    if (obstacle instanceof Wall) {
                        ((Wall) obstacle).accept((Jumpable) participant);
                    } else if (obstacle instanceof RunningTrack) {
                        ((RunningTrack) obstacle).accept((Runnable) participant);

                    }
                }
            }
        }
    }
}
