import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
    public void recursivePreOrder(TreeNode node, List<Integer> preorder){
        if(node == null)return;

        preorder.add(node.val);
        recursivePreOrder(node.left, preorder);
        recursivePreOrder(node.right, preorder);
    }

    public void iterativePreOrder(TreeNode node, List<Integer> preorder){
        if(node == null)return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            preorder.add(curr.val);

            if(curr.right != null)stack.push(curr.right);
            if(curr.left != null)stack.push(curr.left);
        }
    }
}
