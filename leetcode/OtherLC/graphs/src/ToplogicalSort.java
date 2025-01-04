import java.util.*;

/*
Topological sort using DFS
 */
public class ToplogicalSort {
    public int[] topologicalSortDFS(int[][] graph){
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

    public int[] topologicalSortBFS(int[][] graph){
        int V = graph.length;
        int[] indegree = new int[V];
        int[] topologicalOrder = new int[V];
        Arrays.fill(topologicalOrder, -1);

        for(int i = 0; i < V; i++){
            for(int neighbor : graph[i]){
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topologicalOrder[index++] = node;

            for(int neighbor : graph[node]){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return topologicalOrder;
    }
}
