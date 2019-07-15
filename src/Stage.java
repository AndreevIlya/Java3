public abstract class Stage {
    int length;
    String description;

    String getDescription() {
        return description;
    }

    public abstract int go(Car c);
}
