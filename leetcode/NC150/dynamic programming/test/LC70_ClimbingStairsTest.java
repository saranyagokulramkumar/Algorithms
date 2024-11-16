import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC70_ClimbingStairsTest {
    static LC70_ClimbingStairs solution;

    @BeforeAll
    public static void init(){
        solution = new LC70_ClimbingStairs();
    }

    @Test
    public void testClimbingStairs(){
        int n = 2;
        int expectedResult = 2;

        assertEquals(expectedResult, solution.climbStairsIterative(n));
        assertEquals(expectedResult, solution.climbStairsRecursive(n));

        n = 3;
        expectedResult = 3;
        assertEquals(expectedResult, solution.climbStairsIterative(n));
        assertEquals(expectedResult, solution.climbStairsRecursive(n));
    }
}
