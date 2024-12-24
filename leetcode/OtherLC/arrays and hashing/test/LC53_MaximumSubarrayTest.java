import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC53_MaximumSubarrayTest {
    static LC53_MaximumSubarray solution;

    @BeforeAll
    public static void init(){
        solution = new LC53_MaximumSubarray();
    }

    @Test
    public void testMaxSubArrayKadane(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int expectedResult = 6;
        int maxStart = 3;
        int maxEnd = 6;
        int[] result = solution.maxSubArrayKadane(nums);

        assertEquals(result[0], expectedResult);
        assertEquals(result[1], maxStart);
        assertEquals(result[2], maxEnd);

        nums = new int[]{1};
        expectedResult = 1;
        result = solution.maxSubArrayKadane(nums);

        assertEquals(result[0], expectedResult);

        nums = new int[]{5,4,-1,7,8};
        maxStart = 0;
        maxEnd = 4;
        expectedResult = 23;
        result = solution.maxSubArrayKadane(nums);

        assertEquals(result[0], expectedResult);
        assertEquals(result[1], maxStart);
        assertEquals(result[2], maxEnd);
    }

    @Test
    public void testMaxSubArrayDivideAndConquer(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int expectedResult = 6;
        int result = solution.maxSubArrayDivideAndConquer(nums, 0, nums.length - 1);

        assertEquals(result, expectedResult);

        nums = new int[]{1};
        expectedResult = 1;
        result = solution.maxSubArrayDivideAndConquer(nums, 0, nums.length - 1);

        assertEquals(result, expectedResult);

        nums = new int[]{5,4,-1,7,8};
        expectedResult = 23;
        result = solution.maxSubArrayDivideAndConquer(nums, 0, nums.length - 1);

        assertEquals(result, expectedResult);
    }
}
