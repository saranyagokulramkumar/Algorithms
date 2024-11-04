import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC90_SubsetsIITest {
    static LC90_SubsetsII solution;

    @BeforeAll
    public static void init(){
        solution = new LC90_SubsetsII();
    }

    @Test
    public void testSubsetsII(){
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList());
        expectedResult.add(Arrays.asList(1));
        expectedResult.add(Arrays.asList(1,2));
        expectedResult.add(Arrays.asList(1,2,2));
        expectedResult.add(Arrays.asList(2));
        expectedResult.add(Arrays.asList(2,2));

        List<List<Integer>> result = solution.subsetsWithDup(nums);

        assertEquals(result, expectedResult);
    }
}
