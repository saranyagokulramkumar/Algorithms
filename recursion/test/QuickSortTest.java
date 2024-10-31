import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    static QuickSort solution;

    @BeforeAll
    public static void init(){
        solution = new QuickSort();
    }

    @Test
    public void testQuickSort(){
        int[] nums = new int[]{4,6,2,5,7,9,1,3};
        int[] expectedResult = new int[]{1,2,3,4,5,6,7,9};

        int[] result = solution.quickSort(nums, 0, nums.length - 1);
        assertArrayEquals(result, expectedResult);
    }
}
