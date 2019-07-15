import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class Main {
    static final int CARS_COUNT = 4;
    private static Race race = new Race(new Road(600),
            new Tunnel(300),
            new Road(400),
            new Tunnel(400),
            new Road(100),
            new Tunnel(600),
            new Road(700));
    private static final int STAGES_COUNT = race.getStagesCount();

    private static CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
    private static CountDownLatch cdlStart;
    private static CountDownLatch[] cdlStages = new CountDownLatch[STAGES_COUNT];
    private static CountDownLatch cdlFinish;

    private static Future[] results;
    private static ExecutorService service;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        startRace();
        makeAnnouncements();
        showResults(results);
        service.shutdown();
    }

    @Contract(pure = true)
    static CyclicBarrier getBarrier() {
        return barrier;
    }

    @Contract(pure = true)
    static CountDownLatch getCDLStart() {
        return cdlStart;
    }

    @Contract(pure = true)
    static CountDownLatch[] getCDLStages() {
        return cdlStages;
    }

    @Contract(pure = true)
    static CountDownLatch getCDLFinish() {
        return cdlFinish;
    }

    private static void announceStart() {
        System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }

    private static void announceFinish() {
        System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    private static void startRace() {
        service = Executors.newFixedThreadPool(CARS_COUNT);
        results = new Future[CARS_COUNT];
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            results[i] = service.submit(cars[i]);
        }
    }

    private static void makeAnnouncements() {
        try {
            cdlStart = new CountDownLatch(CARS_COUNT);
            cdlStart.await();
            announceStart();
            for (int i = 0; i < cdlStages.length; i++) {
                cdlStages[i] = new CountDownLatch(CARS_COUNT);
                cdlStages[i].await();
                System.out.println("Закончен этап " + race.getStages().get(i).getDescription() + ".\n");
            }
            cdlFinish = new CountDownLatch(CARS_COUNT);
            cdlFinish.await();
            announceFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void showResults(@NotNull Future[] results) {
        int time = Integer.MAX_VALUE;
        int position = 0;
        int temp;
        System.out.println();
        for (int i = 0; i < results.length; i++) {
            Future future = results[i];
            try {
                temp = (int) future.get();
                System.out.printf("Время участника № %d - %d.\n", i + 1, temp);
                if (temp < time) {
                    time = temp;
                    position = i;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nПобедил участник № " + (position + 1));
    }
}

