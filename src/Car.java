import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Car implements Callable<Integer> {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + ++CARS_COUNT;
    }

    @Override
    public Integer call() {
        int time = 0;
        try {
            System.out.printf("%s готовится. Его скорость %d м/с.\n", this.name, this.speed);
            Main.getBarrier().await();
            time += 5 + (int) (Math.random() * 10);
            Thread.sleep(time * 100);
            System.out.printf("%s готов за %d секунд.\n", this.name, time);
            Main.getCDLStart().countDown();
            Main.getBarrier().await();
            CountDownLatch[] cdlStages = Main.getCDLStages();
            for (int i = 0; i < race.getStages().size(); i++) {
                Thread.sleep(100);//Time to receive an announcement about the stage's end.
                Stage stage = race.getStages().get(i);
                time += stage.go(this);
                cdlStages[i].countDown();
                Main.getBarrier().await();
            }
            Thread.sleep(100);//Time to init finish countDownLatch
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.getCDLFinish().countDown();
        return time;
    }
}