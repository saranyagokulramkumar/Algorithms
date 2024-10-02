import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LC15_3SumTest {
    static LC15_3Sum solution;
    @BeforeAll
    public static void init(){
        solution = new LC15_3Sum();
    }

    @Test
    public void testThreeSumSorting(){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(-1,-1,2));
        expectedResult.add(Arrays.asList(-1,0,1));

        List<List<Integer>> result = solution.threeSumSorting(nums);

        assertEquals(result, expectedResult);

        nums = new int[]{0,1,1};
        expectedResult.clear();
        assertEquals(solution.threeSumSorting(nums), expectedResult);

        nums = new int[]{0,0,0};
        expectedResult.clear();
        expectedResult.add(Arrays.asList(0,0,0));
        result = solution.threeSumSorting(nums);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testThreeSumNoSorting(){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(-1,0,1));
        expectedResult.add(Arrays.asList(-1,-1,2));

        List<List<Integer>> result = solution.threeSumNoSorting(nums);

        assertEquals(result, expectedResult);

        nums = new int[]{0,1,1};
        expectedResult.clear();
        assertEquals(solution.threeSumNoSorting(nums), expectedResult);

        nums = new int[]{0,0,0};
        expectedResult.clear();
        expectedResult.add(Arrays.asList(0,0,0));
        result = solution.threeSumNoSorting(nums);
        assertEquals(result, expectedResult);
    }
}
