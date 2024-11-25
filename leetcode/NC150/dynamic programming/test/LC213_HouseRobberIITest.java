import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC213_HouseRobberIITest {
    static LC213_HouseRobberII solution;

    @BeforeAll
    public static void init(){
        solution = new LC213_HouseRobberII();
    }

    @Test
    public void testRob(){
        int[] nums = new int[]{2,3,2};
        int expectedResult = 3;

        int result = solution.rob(nums);
        assertEquals(result, expectedResult);

        nums = new int[]{1,2,3,1};
        expectedResult = 4;
        result = solution.rob(nums);
        assertEquals(result, expectedResult);
    }
}
