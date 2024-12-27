import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycle {
    private boolean detectCycle(List<List<Integer>> graph, int source, boolean[] visited){
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(source, -1));

        while(!queue.isEmpty()){
            Pair<Integer, Integer> pair = queue.poll();
            int node = pair.getKey();
            int parent = pair.getValue();

            for(int neighbor : graph.get(node)){
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Pair<>(neighbor, node));
                }else if(parent != neighbor){
                    return true;
                }
            }
         }
        return false;
    }

    public boolean isCyclicBFS(List<List<Integer>> graph){
        int V = graph.size();
        boolean[] visited = new boolean[V+1];

        for(int node = 1; node < V+1; node++){
            if(!visited[node]){
                if(detectCycle(graph, node, visited))return true;
            }
        }
        return false;
    }

    public boolean isCyclicDFS(List<List<Integer>> graph){
        int V = graph.size();
        boolean[] visited = new boolean[V + 1];

        for(int node = 1; node < V+1; node++){
            if(!visited[node]){
                if(detectCycleDFS(graph, node, -1, visited))return true;
            }
        }
        return false;
    }

    private boolean detectCycleDFS(List<List<Integer>> graph, int node, int parent, boolean[] visited){

        visited[node] = true;
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(detectCycleDFS(graph, neighbor, node, visited))return true;
            }else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }
}
