import org.jetbrains.annotations.NotNull;

public class Road extends Stage {
    Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public int go(@NotNull Car car) {
        int time = 0;
        try {
            System.out.println(car.getName() + " начал этап: " + description);
            time = length / car.getSpeed();
            Thread.sleep(time * 100);
            System.out.printf("%s закончил этап: %s за %d секунд.\n", car.getName(), description, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return time;
    }
}