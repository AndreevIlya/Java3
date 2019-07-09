public class Main {
    private static final int COUNT = 5;
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main m = new Main();
        new Thread(m::printA).start();
        new Thread(m::printB).start();
    }

    private synchronized void printA() {
        for (int i = 0; i < COUNT; i++) {
            try {
                while (currentLetter != 'A') {
                    this.wait();
                }
                System.out.print(currentLetter);
                currentLetter = 'B';
                this.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printB() {
        for (int i = 0; i < COUNT; i++) {
            try {
                while (currentLetter != 'B') {
                    this.wait();
                }
                System.out.print(currentLetter);
                currentLetter = 'A';
                this.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
