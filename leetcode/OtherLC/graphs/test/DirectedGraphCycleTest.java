import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DirectedGraphCycleTest {
    static DirectedGraphCycle solution;

    @BeforeAll
    public static void init(){
        solution = new DirectedGraphCycle();
    }

    @Test
    public void testIsCyclicDFS(){
        int[][] graph = {{-1,-1}, {2,3}, {1,4}, {1}, {2}, {6}, {5}, {8,9},{7,9},{7,8}};
        assertTrue(solution.isCyclicDFS(graph));
    }

    @Test
    public void testIsCyclicBFS(){
        int[][] graph = {{-1,-1}, {2,3}, {1,4}, {1}, {2}, {6}, {5}, {8,9},{7,9},{7,8}};
        assertTrue(solution.isCyclicBFS(graph));
    }
}
