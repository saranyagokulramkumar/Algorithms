import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC238_ProductOfArrayExceptSelfTest {
    static LC238_ProductOfArrayExceptSelf solution;
    @BeforeAll
    public static void init(){
        solution = new LC238_ProductOfArrayExceptSelf();
    }

    @Test
    public void testProductExceptSelf(){
        int[] nums = new int[]{1,2,3,4};
        int[] expectedResult = new int[]{24,12,8,6};

        int[] result = solution.productExceptSelf(nums);

        assertArrayEquals(result, expectedResult);

        nums = new int[]{-1,1,0,-3,3};
        expectedResult = new int[]{0,0,9,0,0};
        result = solution.productExceptSelf(nums);

        assertArrayEquals(result, expectedResult);
    }
}
