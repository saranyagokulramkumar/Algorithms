import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC785_BipartiteGraphTest {
    static LC785_BipartiteGraph solution;

    @BeforeAll
    public static void init(){
        solution = new LC785_BipartiteGraph();
    }

    @Test
    public void testBipartiteGraphBFS(){
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        boolean expectedResult = false;

        boolean result = solution.isBipartiteBFS(graph);

        assertEquals(result, expectedResult);
    }

    @Test
    public void testBipartiteGraphDFS(){
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        boolean expectedResult = false;

        boolean result = solution.isBipartiteDFS(graph);

        assertEquals(result, expectedResult);
    }
}
