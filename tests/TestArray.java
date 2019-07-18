import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class TestArray {
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new int[][][]{
                {{3, 5, 7, 8}, {4, 3, 5, 7, 8}},
                {{}, {4, 3, 5, 7, 4}},
                {{1, 3}, {4, 3, 5, 4, 1, 3}}
        });
    }

    private int[] result;
    private int[] input;

    public TestArray(int[] result, int[] input) {
        this.result = result;
        ArrayWith4.writeArray(result);
        this.input = input;
        ArrayWith4.writeArray(input);
    }

    @Test
    public void testArrayCut() {
        Assert.assertArrayEquals(result, ArrayWith4.getItemsAfterLast4(input));
    }

    @Test
    public void testCut() {
        Assert.assertArrayEquals(new int[]{1, 2}, ArrayWith4.getItemsAfterLast4(new int[]{4, 1, 2}));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        Assert.assertArrayEquals(new int[]{1, 2}, ArrayWith4.getItemsAfterLast4(new int[]{3, 1, 2}));
    }
}