import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Q-https://leetcode.com/problems/find-eventual-safe-states/description/
**Approach**
DFS
* init visited[], pathVisited[], safeCheck[] of length V
* now to account for disconnected components, run a for loop for vertices from 0 to V, and if it is not visited, call dfs(v, visited, pathvisited, safecheck, graph)
* after dfs is complete on all nodes, go through the safeCheck array and for each node that has a 1, add the node to the List safeNodes to be returned as a result
* Inside the dfs function, first mark the source node as visited, pathVisited and safeCheck is 0 initially
* Now, for each neighbor of the node in the graph, if it is not visited, invoke dfs on this node and if the dfs call returns true, which means that there is a cycle somewhere in the path, return true immediately.
* If the neighbor is visited already, check if it is also marked in the pathVisited array, which indicates this node is part of a cycle. REturn true immediately
* After processing all neighbor nodes, we mark pathVisited[source] as 0 and safeCheck[source] as 1 cos the path starting from source led to a terminal node or other safe state.
* Return false (indicating there is no cycle)
* REturn the safeNodes arraylist from the main function

*Time complexity* - O(V+E)
*Space complexity* - O(V)
 */
public class LC802_EventualSafeStates {
    public List<Integer> eventualSafeNodesDFS(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        int[] safeCheck = new int[V];
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i, visited, pathVisited, safeCheck, graph);
            }
        }

        // iterate through the safeCheck array and populate the list of nodes that are terminal
        for(int i = 0; i < V; i++){
            if(safeCheck[i] == 1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean dfs(int source, int[] visited, int[] pathVisited, int[] safeCheck, int[][] graph){
        visited[source] = 1;
        pathVisited[source] = 1;
        safeCheck[source] = 0;

        for(int neighbor : graph[source]){
            if(visited[neighbor] == 0){
                if(dfs(neighbor, visited, pathVisited, safeCheck, graph)){
                    return true; // there is a cycle somewhere in the path
                }
            }else if(pathVisited[neighbor] == 1){
                return true; // there is a cycle if the node has been visited and is in the same path we are currently on
            }
        }
        //unmark the pathvisited
        pathVisited[source] = 0;
        safeCheck[source] = 1; // since we have reached a terminal vertex with no more paths going out
        return false;
    }

    public List<Integer> eventualSafeNodesBFS(int[][] graph){
        // using topological sort
        // 1. reverse the edges in the graph
        int V = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int u = 0; u < V; u++){
            for(int neighbor : graph[u]){
                // u -> v => v ->u
                adjRev.get(neighbor).add(u);
                indegree[u]++;
            }
        }

        // 2. perform topological sort
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        boolean[] safe = new boolean[V];
        while(!queue.isEmpty()){
            int node = queue.poll();
            safe[node] = true;

            for(int neighbor : adjRev.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        for(int i = 0; i < V; i++){
            if(safe[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}
