import java.util.*;

/*
Q- https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
**Approaches**
1. Iterative BFS
* create a q to store the nodes and add root to it
* while the q is not empty, get the levelsize as the current size of the q and create a new deque to store the current levels elements and initialize a boolean flag leftToRight to true to determine the order
* now run a for loop from i = 0 to levelsize and poll elements from the q. if the lefttoright flag is set, we add elements from the q to the dq in left->right order, otherwise right->left order.
* Next check if current node has left and right children, if so add it to the q.
* after the for loop ends, create a new arraylist with elements from the dq and add it to the result list
* flip the lefttoright flag to flip the direction of nodes in the next level
* return result from main

*Time complexity* - O(N), each node is processed once
*Space complexity* - O(N), the queue can contain N/2 nodes in a perfect binary tree so upper bound will be O(N)

2. Recursive DFS
* state variables = root, level, result
* initial state = root node of the tree, 0, list<list<integer>>
* base case: if root is null return
* recurrence relation: if level doesn't exist, add a new linkedlist to the list of list; if level %2 is 0 (even level left->right) add element to the last of the dq else (odd level right->left) add elements to the first of the dq(linkedlist); then recursively call the function on root.left, level + 1, result and root.right, level + 1, result
* return result from main

*Time complexity* - O(N), each node is processed once
	*Space complexity* - O(h), h -> height of the tree, = N for a skewed tree, = logN for a height-balanced tree
 */
public class LC103_ZigZagTraversal {

    public void zigzagIterative(TreeNode root, List<List<Integer>> result){
        if(root == null)return;

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int levelSize = q.size();
            Deque<Integer> level = new ArrayDeque();

            for(int i = 0; i < levelSize; i++){
                TreeNode current = q.poll();
                if(leftToRight){
                    level.addLast(current.val);
                }else{
                    level.addFirst(current.val);
                }

                if(current.left != null)q.offer(current.left);
                if(current.right != null)q.offer(current.right);
            }
            result.add(new ArrayList<>(level));
            leftToRight = !leftToRight;
        }
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)return;

        // if level doesn't exist, create it
        if(level >= result.size()){
            result.add(new LinkedList<>());
        }

        if(level % 2 == 0){
            result.get(level).addLast(root.val); // even level: add to last
        }else{
            result.get(level).addFirst(root.val); // odd level: add to first
        }

        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}
