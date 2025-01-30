import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC1249_MinimumRemoveValidParenthesesTest {
    static LC1249_MinimumRemoveValidParentheses solution;

    @BeforeAll
    public static void init(){
        solution = new LC1249_MinimumRemoveValidParentheses();
    }

    @Test
    public void testSolutionWithStack(){
        String s = "lee(t(c)o)de)";
        String result = "lee(t(c)o)de";

        String expectedResult = solution.solutionWithStack(s);
        assertEquals(result, expectedResult);
    }

    @Test
    public void testSolutionWithoutStack(){
        String s = "lee(t(c)o)de)";
        String result = "lee(t(c)o)de";

        String expectedResult = solution.solutionWithoutStack(s);
        assertEquals(result, expectedResult);
    }
}
