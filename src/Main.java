public class Main {
    private static final int COUNT = 10;
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main m = new Main();
        new Thread(m::printA).start();
        new Thread(m::printB).start();
        new Thread(m::printC).start();
    }

    private synchronized void printA() {
        for (int i = 0; i < COUNT; i++) {
            try {
                while (currentLetter != 'A') {
                    this.wait();
                }
                System.out.print(currentLetter);
                if (currentLetter == 'A') currentLetter = 'B';
                else currentLetter = 'C';
                this.notifyAll();
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
                if (currentLetter == 'B') currentLetter = 'C';
                else currentLetter = 'A';
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printC() {
        for (int i = 0; i < COUNT; i++) {
            try {
                while (currentLetter != 'C') {
                    this.wait();
                }
                System.out.print(currentLetter);
                if (currentLetter == 'C') currentLetter = 'A';
                else currentLetter = 'B';
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
