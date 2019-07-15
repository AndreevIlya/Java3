import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    static final int CARS_COUNT = 4;
    private static CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
    private static CountDownLatch cdlStart;
    private static CountDownLatch cdlFinish;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        makeAnnouncements();
    }

    static CyclicBarrier getBarrier() {
        return barrier;
    }

    private static void announceStart() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }

    private static void announceFinish() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    static CountDownLatch getCdlStart() {
        return cdlStart;
    }

    static CountDownLatch getCdlFinish() {
        return cdlFinish;
    }

    private static void makeAnnouncements() {
        try {
            cdlStart = new CountDownLatch(CARS_COUNT);
            cdlStart.await();
            announceStart();
            cdlFinish = new CountDownLatch(CARS_COUNT);
            cdlFinish.await();
            announceFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

