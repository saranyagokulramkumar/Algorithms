import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC987_BinaryTreeVerticalOrderTraversalTest {
    static LC987_BinaryTreeVerticalOrderTraversal solution;

    @BeforeAll
    public static void init(){
        solution = new LC987_BinaryTreeVerticalOrderTraversal();
    }

    @Test
    public void testVerticalOrderTraversal(){
        TreeNode root = new TreeNode(3);
        root.left  = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(new ArrayList<>(Arrays.asList(9)));
        expectedResult.add(new ArrayList<>(Arrays.asList(3,15)));
        expectedResult.add(new ArrayList<>(Arrays.asList(20)));
        expectedResult.add(new ArrayList<>(Arrays.asList(7)));

        List<List<Integer>> result = solution.verticalTraversal(root);
        assertEquals(result, expectedResult);
    }
}
