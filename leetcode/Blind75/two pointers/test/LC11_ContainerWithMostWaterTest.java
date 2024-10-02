import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC11_ContainerWithMostWaterTest {
    static LC11_ContainerWithMostWater solution;
    @BeforeAll
    public static void init(){
        solution = new LC11_ContainerWithMostWater();
    }

    @Test
    public void testMaxArea(){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int expectedResult = 49;

        assertEquals(solution.maxArea(height), expectedResult);

        height = new int[]{1,1};
        expectedResult = 1;
        assertEquals(solution.maxArea(height), expectedResult);
    }
}
