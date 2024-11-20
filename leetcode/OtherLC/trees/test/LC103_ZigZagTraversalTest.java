import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC103_ZigZagTraversalTest {
    static LC103_ZigZagTraversal solution;

    @BeforeAll
    public static void init(){
        solution = new LC103_ZigZagTraversal();
    }

    @Test
    public void testZigZagIterative(){
        List<List<Integer>> expectedResult = new ArrayList();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        expectedResult.add(Arrays.asList(3));
        expectedResult.add(Arrays.asList(20,9));
        expectedResult.add(Arrays.asList(15,7));

        List<List<Integer>> result = new ArrayList<>();
        solution.zigzagIterative(root, result);

        assertEquals(result, expectedResult);
    }

    @Test
    public void testZigZagRecursive(){
        List<List<Integer>> expectedResult = new ArrayList();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        expectedResult.add(Arrays.asList(3));
        expectedResult.add(Arrays.asList(20,9));
        expectedResult.add(Arrays.asList(15,7));

        List<List<Integer>> result = new ArrayList<>();
        solution.dfs(root, 0, result);

        assertEquals(result, expectedResult);
    }
}
