import java.util.Random;

class Apple extends Fruit {

    Apple() {
        this.weight = ((float) new Random().nextInt(2) + 1) / 3;
    }
}
