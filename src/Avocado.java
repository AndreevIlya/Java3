import java.util.Random;

class Avocado extends Fruit {

    Avocado() {
        this.weight = (new Random().nextFloat() * 4 + 1) / 5;
    }
}
