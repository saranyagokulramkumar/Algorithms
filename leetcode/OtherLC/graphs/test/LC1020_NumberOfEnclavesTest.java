import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC1020_NumberOfEnclavesTest {
    static LC1020_NumberOfEnclaves solution;

    @BeforeAll
    public static void init(){
        solution = new LC1020_NumberOfEnclaves();
    }

    @Test
    public void testNumEnclavesBFS(){
        int[][] matrix = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int expectedResult = 3;

        int result = solution.numEnclavesBFS(matrix);

        assertEquals(result, expectedResult);

    }

    @Test
    public void testNumEnclavesDFS(){
        int[][] matrix = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int expectedResult = 3;

        int result = solution.numEnclavesDFS(matrix);

        assertEquals(result, expectedResult);

    }
}
