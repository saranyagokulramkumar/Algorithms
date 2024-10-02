import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC125_ValidPalindromeTest {
    static LC125_ValidPalindrome solution;
    @BeforeAll
    public static void init(){
        solution = new LC125_ValidPalindrome();
    }

    @Test
    public void testValidPalindrome(){
        String s = new String("A man, a plan, a canal: Panama");
        assertEquals(solution.isPalindrome(s), true);

        s = new String("race a car");
        assertEquals(solution.isPalindrome(s), false);
    }
}
