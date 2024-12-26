import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC100_NumberOfIslandsTest {
    static LC100_NumberOfIslands solution;

    @BeforeAll
    public static void init(){
        solution = new LC100_NumberOfIslands();
    }

    @Test
    public void testNumIslandsDFS(){
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1','1','0','0','0'};
        grid[1] = new char[]{'1','1','0','0','0'};
        grid[2] = new char[]{'0','0','1','0','0'};
        grid[3] = new char[]{'1','1','0','0','0'};

        int expectedResult = 3;
        int result = solution.numIslandsDFS(grid);

        assertEquals(result, expectedResult);
    }

    @Test
    public void testNumIslandsBFS(){
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1','1','0','0','0'};
        grid[1] = new char[]{'1','1','0','0','0'};
        grid[2] = new char[]{'0','0','1','0','0'};
        grid[3] = new char[]{'1','1','0','0','0'};

        int expectedResult = 3;
        int result = solution.numIslandsBFS(grid);

        assertEquals(result, expectedResult);
    }

}
