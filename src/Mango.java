import java.util.Random;

class Mango extends Fruit {

    Mango() {
        this.weight = ((float) new Random().nextInt(3) + 1) / 4;
    }
}
