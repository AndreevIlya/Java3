import java.util.Random;

class Mango extends Fruit {

    Mango() {
        this.weight = (new Random().nextFloat() * 3 + 1) / 4;
    }
}
