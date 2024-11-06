import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC131_PalindromPartitioningTest {
    static LC131_PalindromPartitioning solution;

    @BeforeAll
    static void init(){
        solution = new LC131_PalindromPartitioning();
    }

    @Test
    public void testPartition(){
        String s = "aab";
        List<List<String>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList("a","a","b"));
        expectedResult.add(Arrays.asList("aa","b"));

        List<List<String>> result = solution.partition(s);

        assertEquals(result, expectedResult);
    }
}
