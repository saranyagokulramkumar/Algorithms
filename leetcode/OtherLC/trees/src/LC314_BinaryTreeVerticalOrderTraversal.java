import java.util.*;

/*
Q-https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
**Approach**
BFS
1. state - map(integer, List(Integer)) to hold the axis to list of integers in the axis, queue(pair(treenode, integer)) to hold the node and axis, min -> minimum axis on the left, max -> maximum axis on the right
2. start by placing root node with axis 0 in the queue
3. while queue is not empty, process each pair and add the root.val to particular list in the map using the axis as the key
4. update min with minimum of min and axis, max with maximum of max and axis
5. if root has left child, add it to the queue with axis - 1
6. if root has right child, add it to the queue with axis + 1
7. loop from min to max and add each arraylist value from the map to the result list(list(integer))
8. return result

*Time complexity* - O(N) -> BFS is O(N), inserting in hashmap is O(N) (for each node there is an insertion), iterating from min to max is O(N) (takes atmost this time)
*Space complexity* - O(N) -> in worst case (skewed tree), the queue may store all N nodes, O(N) for the hashmap, O(N) for the final result.

 */
public class LC314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;

        Map<Integer, List<Integer>> axisToList = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int min = 0, max = 0;

        queue.offer(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int axis = pair.getValue();

            axisToList.putIfAbsent(axis, new ArrayList<>());
            axisToList.get(axis).add(node.val);

            min = Math.min(min, axis);
            max = Math.max(max, axis);

            if(node.left != null)queue.offer(new Pair<>(node.left, axis - 1));
            if(node.right != null)queue.offer(new Pair<>(node.right, axis + 1));
        }

        for(int i = min; i <= max; i++){
            result.add(axisToList.get(i));
        }

        return result;
    }
}
