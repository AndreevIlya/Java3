public class Main {
    private static final int COUNT = 10;
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main m = new Main();
        new Thread(() -> m.printLetter('A', 'B')).start();
        new Thread(() -> m.printLetter('B', 'C')).start();
        new Thread(() -> m.printLetter('C', 'A')).start();
    }

    private synchronized void printLetter(char first, char next) {
        for (int i = 0; i < COUNT; i++) {
            try {
                while (currentLetter != first) {
                    this.wait();
                }
                System.out.print(currentLetter);
                currentLetter = next;
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
