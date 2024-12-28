import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC802_EventualSafeStatesTest {
    static LC802_EventualSafeStates solution;

    @BeforeAll
    public static void init(){
        solution = new LC802_EventualSafeStates();
    }

    @Test
    public void testEventualSafeNodes(){
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(2,4,5,6));

        List<Integer> result = solution.eventualSafeNodes(graph);

        assertEquals(result, expectedResult);
    }
}
