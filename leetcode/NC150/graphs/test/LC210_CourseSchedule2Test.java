import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC210_CourseSchedule2Test {
    static LC210_CourseSchedule2 solution;

    @BeforeAll
    public static void init(){
        solution = new LC210_CourseSchedule2();
    }

    @Test
    public void testCanFinishBFS(){
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        int[] expectedResult = {0,1,2,3};
        int[] result = solution.topologicalSortBFS(4, prerequisites);

        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void testCanFinishDFS(){
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        int[] expectedResult = {0,1,2,3};
        int[] result = solution.topologicalSortDFS(4, prerequisites);

        assertArrayEquals(result, expectedResult);
    }
}
