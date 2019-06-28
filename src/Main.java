public class Main {

    private static final int APPLES_COUNT = 8;
    private static final int MANGOS_COUNT = 12;
    private static final int AVOCADOS_COUNT = 10;
    private static final int PINEAPPLES_COUNT = 3;

    private static Box<Mango> boxOfMangos;
    private static Box<Apple> boxOfApples;
    private static Box<Avocado> boxOfAvocados;
    private static Box<Pineapple> boxOfPineapples;

    public static void main(String[] args) {
        playArray();
        initBoxes();
        findEqualWeights();
    }

    private static void playArray(){
        String[] arr1 = {"Wine","Beer","Jin","Calvados","Tequila","Cognac","Becherovka"};
        ArrayHandler<String> ah1 = new ArrayHandler<>(arr1);
        ah1.changeElements(2,4);
        ah1.showArray();
        ah1.transformToArrayList();
        ah1.showArrayList();
        Integer[] arr2 = {1,2,3,4,5,6,7};
        ArrayHandler<Integer> ah2 = new ArrayHandler<>(arr2);
        ah2.changeElements(4,2);
        ah2.showArray();
        ah2.transformToArrayList();
        ah2.showArrayList();
    }

    private static void initBoxes(){
        Mango[] mangos = new Mango[MANGOS_COUNT];
        for (int i = 0; i < MANGOS_COUNT; i++) {
            mangos[i] = new Mango();
        }
        Apple[] apples = new Apple[APPLES_COUNT];
        for (int i = 0; i < APPLES_COUNT; i++) {
            apples[i] = new Apple();
        }
        Avocado[] avocados = new Avocado[AVOCADOS_COUNT];
        for (int i = 0; i < AVOCADOS_COUNT; i++) {
            avocados[i] = new Avocado();
        }
        Pineapple[] pineapples = new Pineapple[PINEAPPLES_COUNT];
        for (int i = 0; i < PINEAPPLES_COUNT; i++) {
            pineapples[i] = new Pineapple();
        }
        System.out.print("Mangos ");
        boxOfMangos = new Box<>(mangos);
        System.out.print("Apples ");
        boxOfApples = new Box<>(apples);
        System.out.print("Avocados ");
        boxOfAvocados = new Box<>(avocados);
        System.out.print("Pineapples ");
        boxOfPineapples = new Box<>(pineapples);
    }

    private static void findEqualWeights(){
        System.out.println("Weight more or less equally:");
        if(boxOfApples.areBoxWeightsEqual(boxOfAvocados)) System.out.println("Apples and avocados!");
        if(boxOfApples.areBoxWeightsEqual(boxOfMangos)) System.out.println("Apples and mangos!");
        if(boxOfApples.areBoxWeightsEqual(boxOfPineapples)) System.out.println("Apples and pineapples!");
        if(boxOfMangos.areBoxWeightsEqual(boxOfAvocados)) System.out.println("Mangos and avocados!");
        if(boxOfMangos.areBoxWeightsEqual(boxOfPineapples)) System.out.println("Mangos and pineapples!");
        if(boxOfAvocados.areBoxWeightsEqual(boxOfPineapples)) System.out.println("Avocados and pineapples!");
    }
}
