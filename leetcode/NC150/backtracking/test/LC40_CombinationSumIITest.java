import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC40_CombinationSumIITest {
    static LC40_CombinationSumII solution;

    @BeforeAll
    public static void init(){
        solution = new LC40_CombinationSumII();
    }

    @Test
    public void testCombinationSum(){
        int[] nums = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1,1,6));
        expectedResult.add(Arrays.asList(1,2,5));
        expectedResult.add(Arrays.asList(1,7));
        expectedResult.add(Arrays.asList(2,6));

        List<List<Integer>> result = solution.combinationSum2(nums, target);

        assertEquals(result, expectedResult);
    }
}
