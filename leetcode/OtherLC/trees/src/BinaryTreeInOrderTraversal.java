import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    public void recursiveInorder(TreeNode root, List<Integer> inorder){
        if(root == null)return;

        recursiveInorder(root.left, inorder);
        inorder.add(root.val);
        recursiveInorder(root.right, inorder);
    }

    public void iterativeInorder(TreeNode root, List<Integer> inorder){
        if(root == null)return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(true){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                if(stack.isEmpty())break;
                curr = stack.pop();
                inorder.add(curr.val);
                curr = curr.right;
            }
        }
    }
}
