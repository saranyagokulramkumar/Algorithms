import java.util.LinkedList;
import java.util.Stack;

/*
Topological sort using DFS
 */
public class ToplogicalSort {
    public int[] topologicalSort(int[][] graph){
        int V = graph.length;
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i, visited, graph, stack);
            }
        }

        int[] topologicalOrder = new int[V];
        int i = 0;
        while(!stack.isEmpty()){
            topologicalOrder[i++] = stack.pop();
        }
        return topologicalOrder;
    }

    private void dfs(int source, int[] visited, int[][] graph, Stack<Integer> stack){
        visited[source] = 1;
        for(int neighbor : graph[source]){
            if(visited[neighbor] == 0){
                dfs(neighbor, visited, graph, stack);
            }
        }
        stack.push(source);
    }
}
