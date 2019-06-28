import java.util.Random;

class Apple extends Fruit {

    Apple() {
        this.weight = (new Random().nextFloat() * 2 + 1) / 3;
    }
}
