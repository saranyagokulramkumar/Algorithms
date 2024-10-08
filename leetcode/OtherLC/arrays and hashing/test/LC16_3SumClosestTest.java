import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC16_3SumClosestTest {
    static LC16_3SumClosest solution;
    @BeforeAll
    public static void init(){
        solution = new LC16_3SumClosest();
    }

    @Test
    public void test3SumClosest(){
        int[] nums = new int[]{-1,2,1,-4};
        int expectedResult = 2;
        int output = solution.threeSumClosest(nums, 1);

        assertEquals(expectedResult, output);

        nums = new int[]{0,0,0};
        expectedResult = 0;
        output = solution.threeSumClosest(nums, 1);
        assertEquals(expectedResult, output);

    }
}
