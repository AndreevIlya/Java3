import java.util.ArrayList;
import java.util.List;

class Box<F extends Fruit> {
    private List<F> content = new ArrayList<>();

    Box(F[] fruits){
        for(F fruit : fruits){
            addFruit(fruit);
        }
        System.out.println(this.getWeight());
    }

    private void addFruit(F fruit){
        content.add(fruit);
    }

    /*
     * Take fruits from boxFrom and put to BoxTo, so apply as
     * BoxFrom.addToBox(BoxTo)
     * */

    void putToBox(Box<F> box) {
        for (F fruit : this.content) {
            box.addFruit(fruit);
        }
        content = new ArrayList<>();
    }

    float getWeight() {
        float weight = 0;
        for(F fruit : content){
            weight += fruit.getWeight();
        }
        return weight;
    }

    boolean areBoxesWeightsEqual(Box<? extends Fruit> box) {
        float thisWeight = this.getWeight();
        float boxWeight = box.getWeight();
        return thisWeight > boxWeight - 0.5f && thisWeight < boxWeight + 0.5f ||
                boxWeight > thisWeight - 0.5f && boxWeight < thisWeight + 0.5f;
    }
}
