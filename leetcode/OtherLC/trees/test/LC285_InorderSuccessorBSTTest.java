import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LC285_InorderSuccessorBSTTest {
    private final LC285_InorderSuccessorBST solution = new LC285_InorderSuccessorBST();

    @Test
    public void testInorderSuccessorBST(){
        // Construct the tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Find nodes
        TreeNode node2 = root.left.left;  // 2
        TreeNode node3 = root.left;       // 3
        TreeNode node4 = root.left.right; // 4
        TreeNode node5 = root;            // 5
        TreeNode node8 = root.right;      // 8
        TreeNode node9 = root.right.right;// 9 (last node)

        // Test cases
        assertEquals(3, solution.inorderSuccessor(root, node2).val); // 2 -> 3
        assertEquals(4, solution.inorderSuccessor(root, node3).val); // 3 -> 4
        assertEquals(5, solution.inorderSuccessor(root, node4).val); // 4 -> 5
        assertEquals(7, solution.inorderSuccessor(root, node5).val); // 5 -> 7
        assertEquals(9, solution.inorderSuccessor(root, node8).val); // 8 -> 9
        assertNull(solution.inorderSuccessor(root, node9)); // 9 -> null (last node)
    }
}
