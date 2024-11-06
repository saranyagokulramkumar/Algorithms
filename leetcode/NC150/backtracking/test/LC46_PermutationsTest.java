import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC46_PermutationsTest {
    static LC46_Permutations solution;

    @BeforeAll
    static void init(){
        solution = new LC46_Permutations();
    }

    @Test
    public void testFindPermutations(){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1,2,3));
        expectedResult.add(Arrays.asList(1,3,2));
        expectedResult.add(Arrays.asList(2,1,3));
        expectedResult.add(Arrays.asList(2,3,1));
        expectedResult.add(Arrays.asList(3,1,2));
        expectedResult.add(Arrays.asList(3,2,1));

        List<List<Integer>> result = solution.permute(nums);

        assertEquals(result,expectedResult);
    }

    @Test
    public void testFindPermutationsBySwapping(){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1,2,3));
        expectedResult.add(Arrays.asList(1,3,2));
        expectedResult.add(Arrays.asList(2,1,3));
        expectedResult.add(Arrays.asList(2,3,1));
        expectedResult.add(Arrays.asList(3,2,1));
        expectedResult.add(Arrays.asList(3,1,2));

        List<List<Integer>> result = solution.permuteBySwap(nums);

        assertEquals(result,expectedResult);
    }
}
