import com.sun.source.tree.Tree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePreOrderTraversalTest {
    static BinaryTreePreOrderTraversal solution;

    @BeforeAll
    public static void init(){
        solution = new BinaryTreePreOrderTraversal();
    }

    @Test
    public void testRecursivePreOrder(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1,2,4,5,3));
        List<Integer> result = new ArrayList<>();
        solution.recursivePreOrder(root, result);

        assertEquals(result, expectedResult);
    }

    @Test
    public void testIterativePreOrder(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1,2,4,5,3));
        List<Integer> result = new ArrayList<>();
        solution.iterativePreOrder(root, result);

        assertEquals(result, expectedResult);
    }
}
