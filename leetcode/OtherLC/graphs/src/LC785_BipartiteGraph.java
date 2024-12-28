import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Q-https://leetcode.com/problems/is-graph-bipartite/description/
**Approaches**
1. BFS
* init a color array with -1 as initial values
* run a for loop to process all nodes in the graph which hasn't been colored (-1) to account for multiple disjoint components
* invoke the bfs funciton with the uncolored node, total number of nodes, the graph and the color array
* if this function returns false, return false; else return true
* inside the BFS function, init a queue of integer with start as the starting node in the queue, also set color[start] to 0 (starting color)
* now while the queue is not empty, get the size of the queue and process all nodes in this level (must get the color 1 - color[start]
* for each neighbor of the node polled from the queue, if is not colored, color it with 1-color[node] and add it to the queue; if it is colored, check if the color[neighbor] is same as color[node] then there is an odd length cycle and the graph is not bipartite. immediately return false
* after queue becomes empty return true

*Time complexity* - O(V+E), where V is the number of vertices and E is the number of edges.
*Space complexity* - O(V), for the color array and recursion stack

2. DFS
*  init a color array with -1 as initial values
* run a for loop to process all nodes in the graph which hasn't been colored (-1) to account for multiple disjoint components
* invoke the dfs funciton with the uncolored node, starting color(0), the graph and the color array
* inside the dfs function, first set color[node] to col
* then for each neighbor that is not colored, invoke dfs with neighbor and 1-color[node] and if this returns false, immediately return false
* if the neighbor is colored though, and the color is same as the color[node] return false
* return true at the end

*Time complexity* - O(V+E), each node is visited once and all of its neighbors visited once summing upto E
*Space complexity* - O(V), for the color array and recursion stack can be O(V) in worst case for a linear graph

 */
public class LC785_BipartiteGraph {
    public boolean isBipartiteBFS(int[][] graph) {
        // idea: color the graph with 2 colors and no adjacent nodes having the same color
        // if they do then graph is not bipartite
        int nodes = graph.length;

        int[] color = new int[nodes];
        Arrays.fill(color, -1);

        // invoke helper function to perform coloring using BFS on all uncolored nodes
        // this is needed in case graph has multiple disconnected components
        for(int node = 0; node < nodes; node++){
            if(color[node] == -1){
                if(colorGraphBFS(node, nodes, graph, color) == false){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean colorGraphBFS(int start, int nodes, int[][] graph, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0; // starting color

        while(!queue.isEmpty()){
            int size = queue.size();

            // process all nodes at this level at once and assign opposite color
            // if at any point we find a neighbor has been already colored and it is
            // the same color as the parent, we return false immediately
            for(int i = 0; i < size; i++){
                int node = queue.poll();

                // now process all neighbors
                for(int neighbor : graph[node]){
                    if(color[neighbor] == -1){
                        color[neighbor] = 1 - color[node];
                        queue.offer(neighbor);
                    }else if(color[neighbor] == color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph){
        int nodes = graph.length;

        int[] color = new int[nodes];
        Arrays.fill(color, -1);

        // invoke helper function to perform coloring using BFS on all uncolored nodes
        // this is needed in case graph has multiple disconnected components
        for(int node = 0; node < nodes; node++){
            if(color[node] == -1){
                if(colorGraphDFS(node, 0, graph, color) == false){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean colorGraphDFS(int node, int col, int[][] graph, int[] color){
        color[node] = col;
        for(int neighbor : graph[node]){
            if(color[neighbor] == -1){
                if(colorGraphDFS(neighbor, 1 - color[node], graph, color) == false){
                    return false;
                }
            }else if(color[neighbor] == color[node]){
                return false;
            }
        }
        return true;
    }
}
