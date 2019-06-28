import java.util.Random;

class Pineapple extends Fruit {

    Pineapple() {
        this.weight = (new Random().nextFloat() * 4 + 4) / 4;
    }
}
