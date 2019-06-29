import java.util.Random;

class Pineapple extends Fruit {

    Pineapple() {
        this.weight = ((float) new Random().nextInt(4) + 4) / 4;
    }
}
