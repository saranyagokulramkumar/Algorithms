import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
Q-https://leetcode.com/problems/boundary-of-binary-tree/description/
**Approach**
1. Define helper methods to construct left boundary, leaves, and right boundary in reverse order and add all of these in order to the integer arraylist
2. addLeftBoundary helper : start from root.left, if current node is not a leaf, add it to the boundary. keep iterating until current node is not null and if there is a left child assign current to left, if there isn't then assign current to the right child.
3. addLeavesToBoundary helper: do an in-order traversal and recursively call function with left child, add root.val to boundary only if root is a leaf node, then recursively call function with right child. base case: if root is null return
4. addRightBoundary helper: create an arraydeque to hold the right boundary in a stack. start from root.right and do a while loop until current is not null. if current is not a leaf, push it to the stack. update current with right child if it is not null else left child; After the loop ends run another while loop until the stack contains elements, pop elements one by one and add it to the boundary list
5. Return the boundary

Edge cases:
1. in the main function if root is null return an empty list
2. if the tree has only a single node, return only that nodes value as the boundary

*Time complexity* - O(N), each node is visited only once
*Space complexity* - O(h), h -> height of the tree, log N if balanced, N if skewed (excluding the space needed for the boundary list)
 */
public class LC545_BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if(root == null)return boundary;

        // add root value to the boundary
        boundary.add(root.val);

        // check if root is itself a leaf then exit
        if(isLeaf(root))return boundary;

        // add left boundary nodes
        addLeftBoundary(root, boundary);

        // add leaves
        addLeavesToBoundary(root, boundary);

        // add right boundary nodes
        addRightBoundary(root, boundary);

        return boundary;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> boundary){
        TreeNode current = root.left;

        while(current != null){
            if(!isLeaf(current)){
                boundary.add(current.val);
            }

            if(current.left != null){
                current = current.left;
            }else{
                current = current.right;
            }
        }
    }

    private boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null)return true;
        return false;
    }

    private void addLeavesToBoundary(TreeNode root, List<Integer> boundary){
        if(root == null)return;

        addLeavesToBoundary(root.left, boundary);
        if(isLeaf(root)){
            boundary.add(root.val);
        }
        addLeavesToBoundary(root.right, boundary);
    }

    private void addRightBoundary(TreeNode root, List<Integer> boundary){
        Deque<Integer> stack = new ArrayDeque<>();

        TreeNode current = root.right;

        while(current != null){
            if(!isLeaf(current)){
                stack.push(current.val);
            }

            if(current.right != null){
                current = current.right;
            }else{
                current = current.left;
            }
        }

        // pop elements and add to boundary in reverse order
        while(!stack.isEmpty()){
            boundary.add(stack.pop());
        }
    }
}
