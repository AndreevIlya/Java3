import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayHandler<T> {
    private T[] array;
    private List<T> arrayList;

    ArrayHandler(T[] array){
        this.array = array;
    }

    void changeElements(int positionFrom, int positionTo){
        if(positionFrom >= 0 && positionFrom < array.length
                && positionTo < array.length && positionTo >= 0){
            T temp = array[positionTo];
            array[positionTo] = array[positionFrom];
            array[positionFrom] = temp;
        }
    }

    void showArray(){
        System.out.print("{");
        for(T i : array){
            System.out.print(i + ", ");//Not smart, i know
        }
        System.out.println("...}");
    }

    void transformToArrayList(){
        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(array));
    }

    void showArrayList(){
        System.out.print("{");
        for(T i : arrayList){
            System.out.print(i + ", ");//Not smart, i know
        }
        System.out.println("...}");
    }
}
