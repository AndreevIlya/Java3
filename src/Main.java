public class Main {
    public static void main(String[] args) {
        String[] arr1 = {"sadfds","fdht","dsfg","sdh","hfdt","dfhft","dfshr"};
        ArrayHandler<String> ah1 = new ArrayHandler<>(arr1);
        ah1.changeElements(2,4);
        ah1.showArray();
        Integer[] arr2 = {1,2,3,4,5,6,7};
        ArrayHandler<Integer> ah2 = new ArrayHandler<>(arr2);
        ah2.changeElements(4,2);
        ah2.showArray();
    }
}
