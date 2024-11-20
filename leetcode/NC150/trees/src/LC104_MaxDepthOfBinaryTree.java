/*
Q - https://leetcode.com/problems/maximum-depth-of-binary-tree/
**Approaches**
1. BFS, iterative - create a queue and add root node to it. While q is not empty, increment depth, level = q.size() and for i = 0 to level, process nodes from the q by polling each of them and add their left and right children if != null back to the q. return depth.

*Time complexity* - O(N), we visit each node once
*Space complexity* - O(2^(log N-1)) = O(N/2) = O(N) for a complete binary tree, where there will be O(N) leaf nodes which is maximum at a time a queue will hold.

2. DFS, recursive - if root is null return 0, else calculate leftheight and rightheight recursively and return max(left, right) + 1 as the depth.

*Time complexity* - O(N), we visit each node once
*Space complexity* - O(N), in case of skewed tree, there will be O(N) recursive calls on the call stack.
 */

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaxDepthOfBinaryTree {
    public int maxDepthRecursive(TreeNode root){
        if(root == null)return 0;

        int leftHeight = maxDepthRecursive(root.left);
        int rightHeight = maxDepthRecursive(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int maxDepthIterative(TreeNode root){
        if(root == null)return 0;

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            depth++;
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                TreeNode curr = q.poll();
                if(curr.left != null)q.offer(curr.left);
                if(curr.right != null)q.offer(curr.right);
            }
        }
        return depth;
    }
}
