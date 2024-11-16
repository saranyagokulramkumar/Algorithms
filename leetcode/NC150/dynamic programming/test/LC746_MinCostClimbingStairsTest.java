import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC746_MinCostClimbingStairsTest {
    static LC746_MinCostClimbingStairs solution;

    @BeforeAll
    public static void init(){
        solution = new LC746_MinCostClimbingStairs();
    }

    @Test
    public void testMinCostRecursive(){
        int[] cost = new int[]{10,15,20};
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int expectedResult = 15;

        int result = solution.minCostRecursive(n, dp, cost);
        assertEquals(result, expectedResult);

        cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        expectedResult = 6;

        result = solution.minCostRecursive(n, dp, cost);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testMinCostIterative(){
        int[] cost = new int[]{10,15,20};
        int n = cost.length;
        int[] dp = new int[n + 1];
        int expectedResult = 15;

        int result = solution.minCostIterative(n, dp, cost);
        assertEquals(result, expectedResult);

        cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        n = cost.length;
        dp = new int[n + 1];
        expectedResult = 6;

        result = solution.minCostIterative(n, dp, cost);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testMinCostIterativeSpaceOptimized(){
        int[] cost = new int[]{10,15,20};
        int n = cost.length;
        int expectedResult = 15;

        int result = solution.minCostIterativeSpaceOptimized(n, cost);
        assertEquals(result, expectedResult);

        cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        n = cost.length;
        expectedResult = 6;

        result = solution.minCostIterativeSpaceOptimized(n, cost);
        assertEquals(result, expectedResult);
    }
}
