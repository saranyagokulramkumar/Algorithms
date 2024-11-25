import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC5_LongestPalindromicSubstringTest {
    static LC5_LongestPalindromicSubstring solution;

    @BeforeAll
    public static void init(){
        solution = new LC5_LongestPalindromicSubstring();
    }

    @Test
    public void testBruteForce(){
        String s = new String("babad");
        String expectedResult = new String("bab");
        String result = solution.bruteForce(s);
        assertEquals(result, expectedResult);

        s = new String("cbbd");
        expectedResult = new String("bb");
        result = solution.bruteForce(s);
    }

    @Test
    public void testDP(){
        String s = new String("babad");
        String expectedResult = new String("aba");
        String result = solution.dp(s);
        assertEquals(result, expectedResult);

        s = new String("cbbd");
        expectedResult = new String("bb");
        result = solution.dp(s);
        assertEquals(result, expectedResult);

    }

    @Test
    public void testExpandFromCenter(){
        String s = new String("babad");
        String expectedResult = new String("bab");
        String result = solution.expandFromCenters(s);
        assertEquals(result, expectedResult);

        s = new String("cbbd");
        expectedResult = new String("bb");
        result = solution.expandFromCenters(s);
        assertEquals(result, expectedResult);

    }
}
