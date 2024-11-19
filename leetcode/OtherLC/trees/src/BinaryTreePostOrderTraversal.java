import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
    public void recursivePostorder(TreeNode root, List<Integer> postorder){
        if(root == null)return;

        recursivePostorder(root.left, postorder);
        recursivePostorder(root.right, postorder);
        postorder.add(root.val);
    }

    public void iterativePostorder(TreeNode root, List<Integer> postorder){
        if(root == null)return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode peekNode = stack.peek();
                if(peekNode.right != null && lastVisited != peekNode.right){
                    curr = peekNode.right;
                }else{
                    postorder.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }
    }
}
