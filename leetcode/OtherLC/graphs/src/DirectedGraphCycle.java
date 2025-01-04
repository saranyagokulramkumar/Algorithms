import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphCycle {
    public boolean isCyclicBFS(int[][] graph){
        int V = graph.length;
        boolean[] visited = new boolean[V+1];
        boolean[] pathVisiting = new boolean[V+1];
        ToplogicalSort topoSort = new ToplogicalSort();

        for(int node = 1; node < V+1; node++){
            if(!visited[node]){
                int[] topologicalOrder = topoSort.topologicalSortBFS(graph);
                for(int v : topologicalOrder){
                    if(v == -1)return true; // cycle found since node hasn't been added to topo order
                }
            }
        }
        return false;
    }

    public boolean isCyclicDFS(int[][] graph){
        int V = graph.length;
        boolean[] visited = new boolean[V + 1];
        boolean[] pathVisiting = new boolean[V + 1];

        for(int node = 1; node < V+1; node++){
            if(!visited[node]){
                if(detectCycleDFS(graph, node, visited, pathVisiting))return true;
            }
        }
        return false;
    }

    private boolean detectCycleDFS(int[][] graph, int node, boolean[] visited, boolean[] pathVisiting){

        visited[node] = true;
        pathVisiting[node] = true;
        for(int neighbor : graph[node]){
            if(!visited[neighbor]){
                if(detectCycleDFS(graph, neighbor, visited, pathVisiting))return true;
            }else if(pathVisiting[node]){
                return true;
            }
        }
        pathVisiting[node] = false;
        return false;
    }
}
