import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC733_FloodFillTest {
    static LC733_FloodFill solution;

    @BeforeAll
    public static void init(){
        solution = new LC733_FloodFill();
    }

    @Test
    public void testFloodFill(){
        int[][] image = new int[3][3];
        image[0] = new int[]{1,1,1};
        image[1] = new int[]{1,1,0};
        image[2] = new int[]{1,0,1};
        int newColor = 2;

        int[][] expectedResult = new int[3][3];
        expectedResult[0] = new int[]{2,2,2};
        expectedResult[1] = new int[]{2,2,0};
        expectedResult[2] = new int[]{2,0,1};

        int[][] result = solution.floodFill(image, 1,1, newColor);

        assertArrayEquals(result, expectedResult);
    }
}
