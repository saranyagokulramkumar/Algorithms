import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC104_MaxDepthOfBinaryTreeTest {
    static LC104_MaxDepthOfBinaryTree solution;

    @BeforeAll
    public static void init(){
        solution = new LC104_MaxDepthOfBinaryTree();
    }

    @Test
    public void testMaxDepthRecursive(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int expectedResult = 3;
        int result = solution.maxDepthRecursive(root);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testMaxDepthIterative(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int expectedResult = 3;
        int result = solution.maxDepthIterative(root);

        assertEquals(expectedResult, result);
    }
}
