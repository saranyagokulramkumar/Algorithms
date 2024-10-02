import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC128_LongestConsecutiveSequenceTest {
    static LC128_LongestConsecutiveSequence solution;
    @BeforeAll
    public static void init(){
        solution = new LC128_LongestConsecutiveSequence();
    }

    @Test
    public void testLongestConsecutive(){
        int[] nums = new int[]{100,4,200,1,3,2};
        int expectedResult = 4;

        int result = solution.longestConsecutive(nums);
        assertEquals(result, expectedResult);

        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        expectedResult = 9;
        result = solution.longestConsecutive(nums);
        assertEquals(result, expectedResult);
    }
}
