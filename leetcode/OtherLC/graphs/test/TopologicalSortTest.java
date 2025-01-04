import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopologicalSortTest {
    static ToplogicalSort solution;

    @BeforeAll
    public static void init(){
        solution = new ToplogicalSort();
    }

    @Test
    public void testTopologicalSortDFS(){
//        int[][] graph = {{}, {}, {3}, {1}, {0,1}, {0,2}};
        int[][] graph = {{1,0}, {0,1}};
        int[] expectedResult = {5,4,2,3,1,0};

        int[] result = solution.topologicalSortDFS(graph);

        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void testTopologicalSortBFS(){
        int[][] graph = {{}, {}, {3}, {1}, {0,1}, {0,2}};
        int[] expectedResult = {4,5,0,2,3,1};

        int[] result = solution.topologicalSortBFS(graph);

        assertArrayEquals(result, expectedResult);
    }
}
