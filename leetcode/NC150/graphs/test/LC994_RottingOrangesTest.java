import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC994_RottingOrangesTest {
    static LC994_RottingOranges solution;

    @BeforeAll
    public static void init(){
        solution = new LC994_RottingOranges();
    }

    @Test
    public void testRottingOranges(){
        int[][] grid = new int[3][3];
        grid[0] = new int[]{2,1,1};
        grid[1] = new int[]{1,1,0};
        grid[2] = new int[]{0,1,1};

        int expectedResult = 4;
        int result = solution.orangesRotting(grid);

        assertEquals(result, expectedResult);
    }
}
