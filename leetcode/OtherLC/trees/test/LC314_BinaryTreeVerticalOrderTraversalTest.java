import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC314_BinaryTreeVerticalOrderTraversalTest {
    private final LC314_BinaryTreeVerticalOrderTraversal solution = new LC314_BinaryTreeVerticalOrderTraversal();

    @Test
    void givenBinaryTree_whenVerticalOrderTraversal_thenCorrectOutput(){
        // Given
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // When
        List<List<Integer>> result = solution.verticalOrder(root);

        // Then
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(9),
                Arrays.asList(3, 15),
                Arrays.asList(20),
                Arrays.asList(7)
        );
        assertEquals(expected, result);
    }
}
