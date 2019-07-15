import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final Semaphore semaphore = new Semaphore(Main.CARS_COUNT / 2);

    Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public int go(@NotNull Car car) {
        int time = 0;
        try {
            try {
                System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(car.getName() + " начал этап: " + description);
                time = length / car.getSpeed();
                Thread.sleep(time * 100);//To wait 10 times less longer
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.printf("%s закончил этап: %s за %d секунд.\n", car.getName(), description, time);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
}