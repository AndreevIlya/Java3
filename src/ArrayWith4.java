import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ArrayWith4 {
    private static final int[] array = {2, 4, 6, 8, 9, 1, 3, 5, 7, 9, 0, 4, 5, 6, 4, 2, 7, 4, 3, 6, 2, 8, 9};

    public static void main(String[] args) {
        System.out.println(check1And4Presence(array));
        writeArray(array);
        writeArray(getItemsAfterLast4(array));

    }

    static void writeArray(@NotNull int[] arr) {
        if (arr.length == 0) {
            System.out.println("{}");
            return;
        }
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) System.out.print(arr[i] + ",");
            else System.out.println(arr[i] + "}");
        }
    }

    @Contract(pure = true)
    static int[] getItemsAfterLast4(@NotNull int[] arr) throws RuntimeException {
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) position = i;
        }
        if (position == -1) throw new RuntimeException();
        int[] result = new int[arr.length - position - 1];
        System.arraycopy(arr, position + 1, result, 0, arr.length - position - 1);
        return result;
    }

    @Contract(pure = true)
    static boolean check1And4Presence(@NotNull int[] arr) {
        boolean check1 = false, check4 = false;
        for (int a : arr) {
            if (a == 1) check1 = true;
            if (a == 4) check4 = true;
            if (check1 && check4) return true;
        }
        return false;
    }
}
