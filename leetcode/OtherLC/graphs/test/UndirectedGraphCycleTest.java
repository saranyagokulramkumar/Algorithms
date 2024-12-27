import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UndirectedGraphCycleTest {
    static UndirectedGraphCycle solution;

    @BeforeAll
    public static void init(){
        solution = new UndirectedGraphCycle();
    }

    @Test
    public void testIsCyclicBFS(){
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(-1,-1)));
        graph.add(new ArrayList<>(Arrays.asList(2,3)));
        graph.add(new ArrayList<>(Arrays.asList(1,4)));
        graph.add(new ArrayList<>(Arrays.asList(1)));
        graph.add(new ArrayList<>(Arrays.asList(2)));
        graph.add(new ArrayList<>(Arrays.asList(6)));
        graph.add(new ArrayList<>(Arrays.asList(5)));
        graph.add(new ArrayList<>(Arrays.asList(8,9)));
        graph.add(new ArrayList<>(Arrays.asList(7,9)));
        graph.add(new ArrayList<>(Arrays.asList(7,8)));

        assertTrue(solution.isCyclicBFS(graph));
    }

    @Test
    public void testIsCyclicDFS(){
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(-1,-1)));
        graph.add(new ArrayList<>(Arrays.asList(2,3)));
        graph.add(new ArrayList<>(Arrays.asList(1,4)));
        graph.add(new ArrayList<>(Arrays.asList(1)));
        graph.add(new ArrayList<>(Arrays.asList(2)));
        graph.add(new ArrayList<>(Arrays.asList(6)));
        graph.add(new ArrayList<>(Arrays.asList(5)));
        graph.add(new ArrayList<>(Arrays.asList(8,9)));
        graph.add(new ArrayList<>(Arrays.asList(7,9)));
        graph.add(new ArrayList<>(Arrays.asList(7,8)));

        assertTrue(solution.isCyclicDFS(graph));
    }
}
