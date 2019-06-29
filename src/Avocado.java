import java.util.Random;

class Avocado extends Fruit {

    Avocado() {
        this.weight = ((float) new Random().nextInt(4) + 1) / 5;
    }
}
