import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC39_CombinationSumTest {
    static LC39_CombinationSum solution;

    @BeforeAll
    public static void init(){
        solution = new LC39_CombinationSum();
    }

    @Test
    public void testCombinationSum(){
        int[] nums = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(2,2,3));
        expectedResult.add(Arrays.asList(7));

        List<List<Integer>> result = solution.combinationSum(nums, target);

        assertEquals(result, expectedResult);

        nums = new int[]{2};
        target = 1;
        result = solution.combinationSum(nums, target);
        expectedResult.clear();
        assertEquals(result, expectedResult);
    }
}
