import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC198_HouseRobberTest {
    static LC198_HouseRobber solution;

    @BeforeAll
    public static void init(){
        solution = new LC198_HouseRobber();
    }

    @Test
    public void testRecursiveRob(){
        int[] nums = new int[]{1,2,3,1};
        int expectedResult = 4;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int result = solution.recursiveRob(nums.length - 1, memo, nums);
        assertEquals(result, expectedResult);

        nums = new int[]{2,7,9,3,1};
        expectedResult = 12;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        result = solution.recursiveRob(nums.length - 1, memo, nums);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testIterativeRob(){
        int[] nums = new int[]{1,2,3,1};
        int expectedResult = 4;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int result = solution.iterativeRob(nums.length - 1, memo, nums);
        assertEquals(result, expectedResult);

        nums = new int[]{2,7,9,3,1};
        expectedResult = 12;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        result = solution.iterativeRob(nums.length - 1, memo, nums);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testIterativeRobSpaceOptimized(){
        int[] nums = new int[]{1,2,3,1};
        int expectedResult = 4;

        int result = solution.iterativeRobSpaceOptimized(nums.length - 1, nums);
        assertEquals(result, expectedResult);

        nums = new int[]{2,7,9,3,1};
        expectedResult = 12;

        result = solution.iterativeRobSpaceOptimized(nums.length - 1, nums);
        assertEquals(result, expectedResult);
    }
}
