import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC78_SubsetsTest {
    static LC78_Subsets solution;

    @BeforeAll
    public static void init(){
        solution = new LC78_Subsets();
    }
    @Test
    public void testSubsets(){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList());
        expectedResult.add(Arrays.asList(1));
        expectedResult.add(Arrays.asList(1,2));
        expectedResult.add(Arrays.asList(1,2,3));
        expectedResult.add(Arrays.asList(1,3));
        expectedResult.add(Arrays.asList(2));
        expectedResult.add(Arrays.asList(2,3));
        expectedResult.add(Arrays.asList(3));

        List<List<Integer>> result = solution.subsets(nums);

        assertEquals(result, expectedResult);
    }
}
