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
    public void testTopologicalSort(){
        int[][] graph = {{}, {}, {3}, {1}, {0,1}, {0,2}};
        int[] expectedResult = {5,4,2,3,1,0};

        int[] result = solution.topologicalSort(graph);

        assertArrayEquals(result, expectedResult);
    }
}
