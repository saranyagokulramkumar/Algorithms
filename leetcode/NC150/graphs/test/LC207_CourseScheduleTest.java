import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LC207_CourseScheduleTest {
    static LC207_CourseSchedule solution;

    @BeforeAll
    public static void init(){
        solution = new LC207_CourseSchedule();
    }

    @Test
    public void testCanFinishBFS(){
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        assertTrue(solution.canFinishBFS(4, prerequisites));

        prerequisites = new int[][]{{1,0},{0,1}};
        assertFalse(solution.canFinishBFS(2, prerequisites));

    }

    @Test
    public void testCanFinishDFS(){
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        assertTrue(solution.canFinishDFS(4, prerequisites));

        prerequisites = new int[][]{{1,0},{0,1}};
        assertFalse(solution.canFinishDFS(2, prerequisites));
    }
}
