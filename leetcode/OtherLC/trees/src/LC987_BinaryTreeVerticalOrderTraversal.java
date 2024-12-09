import java.util.*;

/*
Q - https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
**Approach**
The idea: Treat each vertical order of nodes as perpendicular lines on the x-axis with root being on the x=0 line. left child of root will be on x=-1 line and right child will be on x=+1 line. Similarly for each node in the tree, keep adding -1 for left children and +1 for right children.

Steps:
1. Create a Tuple class to hold the value combination <node, vertical, level>
2. create a treemap<vertical, treemap<level, pq>> to store the nodes column-wise with each column having nodes organised by their respective levels and within each level, nodes occuring on the same vertical and level being ordered by the priority-queue. The outer treemap ensures that the nodes are grouped by their vertical index (since treemap is sorted by keys, the vertical columns are stored and retrieved in sorted order; the inner treemap groups nodes within the same vertical column by their level; the priority-queue is used to handle multiple nodes that occur at the same vertical index and same level, this ensures that the smallest value is retrieved first when nodes share the same position in the vertical traversal.
3. Now offer <root,0,0> as the initial tuple to the q.
4. While the q is not empty, poll the first node from q and check if the vertical exists in the map, if not add one. Next check if this level is present in the vertical, if not add one. then add the current node's value to the pq.
5. Add the left child if present with tuple <current.left, vertical - 1, level + 1> and the right child if present with tuple<current.right, vertical+1, level + 1>
6. Now iterate through the map and construct the list<list<>> and return the result

*Time complexity* -
1. O(n) for the BFS traversal * O(log V) for outer treemap insertion (V->number of vertical columns, bound by width of tree) * O(log L) for innert treemap (L-> number of levels, bound by height of the tree, O(logN) for a balanced tree) + O(log k) for PQ insertion (k-> number of nodes with same vertical and level, worst case k = n). So the total cost is O(n * log V * log N), for a balanced binary tree reduces to O(n * log^2 n).
2. For output construction O(n * log k), in the worst case k = n, so O(n * log n).

So overall time complexity is O(n * log^2 n)

*Space complexity* - O(N) to store all nodes in the arraylist, O(N) for the map and priorityqueue, so total O(N)
 */
class Tuple{
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
public class LC987_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode current = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }

            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).offer(current.val);

            if(current.left != null){
                q.offer(new Tuple(current.left, vertical - 1, level + 1));
            }
            if(current.right != null){
                q.offer(new Tuple(current.right, vertical + 1, level + 1));
            }
        }

        List<List<Integer>> verticalTraversal = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> cols : map.values()){
            verticalTraversal.add(new ArrayList<>());
            for(PriorityQueue<Integer> col : cols.values()){
                while(!col.isEmpty()){
                    verticalTraversal.get(verticalTraversal.size() - 1).add(col.poll());
                }
            }
        }
        return verticalTraversal;
    }
}
