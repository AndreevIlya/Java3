import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ArrayWith1And4Test {
    @NotNull
    @Contract(pure = true)
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {false, new int[]{3, 5, 7, 8}},
                {false, new int[]{4, 3, 5, 7, 8}},
                {false, new int[]{}},
                {true, new int[]{4, 1, 1, 1, 4}},
                {false, new int[]{1, 3}},
                {true, new int[]{4, 3, 5, 4, 1, 3}}
        });
    }

    private boolean check;
    private int[] input;

    @Contract(pure = true)
    public ArrayWith1And4Test(boolean check, int[] input) {
        this.check = check;
        this.input = input;
    }

    @Test
    public void check1And4Presence() {
        Assert.assertEquals(check, ArrayWith4.check1And4Presence(input));
    }
}