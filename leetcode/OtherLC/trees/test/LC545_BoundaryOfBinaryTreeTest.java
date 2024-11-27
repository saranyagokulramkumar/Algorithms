import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC545_BoundaryOfBinaryTreeTest {
    static LC545_BoundaryOfBinaryTree solution;

    @BeforeAll
    public static void init(){
        solution = new LC545_BoundaryOfBinaryTree();
    }

    @Test
    public void testBoundaryOfBinaryTree(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1,3,4,2));
        List<Integer> result = solution.boundaryOfBinaryTree(root);

        assertEquals(result, expectedResult);

        root = new TreeNode(1);
        expectedResult = new ArrayList<>(Arrays.asList(1));
        result = solution.boundaryOfBinaryTree(root);

        assertEquals(result, expectedResult);

        root = null;
        expectedResult = new ArrayList<>();
        result = solution.boundaryOfBinaryTree(root);

        assertEquals(result, expectedResult);
    }
}
