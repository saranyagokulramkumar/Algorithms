import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LC542_01MatrixTest {
    static LC542_01Matrix solution;

    @BeforeAll
    public static void init(){
        solution = new LC542_01Matrix();
    }

    @Test
    public void testUpdateMatrix(){
        int[][] matrix = {{0,1,0}, {0,1,0}, {0,1,0}, {0,1,0}, {0,1,0}};
        int[][] expectedResult = {{0,1,0}, {0,1,0}, {0,1,0}, {0,1,0}, {0,1,0}};

        int[][] result = solution.updateMatrix(matrix);

        assertArrayEquals(result, expectedResult);
    }
}
