import java.util.*;

/*
Q-https://leetcode.com/problems/course-schedule-ii/submissions/1497327025/
**Approaches**
INIT - construct an adjacency list from the prerequisites array to represent the courses and their prerequisites in the form of a graph; in the same function, construct the indegree[] array for all the courses to identify number of edges ending on any give vertex (course).

1. Topological sort using BFS (Kahn's topological sort algorithm)
* INIT - a queue to hold the courses, a list of integers to hold the topological order of courses, an integer array to hold the topological order
* go through the indegree array and add to queue the courses with 0 as in-degree
* now while the queue is not empty, pop each node from the queue and add it to the topologicalorder array
* for each neighbor of the node popped, decrement indegree by 1(since the prerequisite is satisfied by adding it's parent to the sort oder in the previous step)
* if indegree of the neighbor node now becomes 0, add it to the queue
* after queue is empty, if index on topologicalorder array is same as number of courses, we return topologicalOrder array else we return empty array cos not all courses were reachable using BFS.

*Time complexity* - O(V+E)
*Space complexity* - O(V+E), constructing adj list + other storage

2. Topological sort using DFS
* INIT - boolean visited and pathVisiting arrays, a stack to hold the topological sort order in reverse, an integer array to hold the topological order
* for each course, invoke dfs if node not visited and if it dfs return false, return empty array immediately (cycle found)
* inside the dfs function, set visited[node] as true, pathVisiting[node] as true
* for each neighbor of the node, if neighbor is not visited, invoke dfs recursively and if the call returns false, return false immediately
* if neighbor is visited and pathVisiting[neighbor] is true, there is a cycle, we return false
* after completion of dfs from the starting node, push the node onto the stack, backtrack by setting pathVisiting[node] as false
* return true at the end
* in the main function if stack size is equal to number of courses, pop all nodes from the stack and add it to the topologicalorder array and return the array; else return an empty array.

*Time complexity* - O(V+E)
*Space complexity* - O(V+E), constructing adj list + other storage
 */
public class LC210_CourseSchedule2 {
    public int[] topologicalSortDFS(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        constructAdjList(numCourses, prerequisites, adjList, indegree);

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisiting = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(!dfs(i, visited, pathVisiting, adjList, stack))return new int[]{};
            }
        }

        if(stack.size() == numCourses){
            // go through the stack and construct the topo order
            int index = 0;
            int[] topoOrder = new int[numCourses];

            while(!stack.isEmpty()){
                topoOrder[index++] = stack.pop();
            }
            return topoOrder;
        }
        return new int[]{};
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisiting, List<List<Integer>> adjList, Stack<Integer> stack){
        visited[node] = true;
        pathVisiting[node] = true;
        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                if(!dfs(neighbor, visited, pathVisiting, adjList, stack)) return false;
            }else if(pathVisiting[neighbor]){
                // there is a cycle so return false
                return false;
            }
        }
        stack.push(node);
        pathVisiting[node] = false;
        return true;
    }

    public int[] topologicalSortBFS(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        constructAdjList(numCourses, prerequisites, adjList, indegree);

        Queue<Integer> queue = new LinkedList<>();
        int[] topoOrder = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoOrder[index++] = node;

            for(int neighbor : adjList.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        if(index == numCourses)return topoOrder;
        return new int[]{};
    }

    private void constructAdjList(int numCourses, int[][] prerequisites, List<List<Integer>> adjList, int[] indegree){
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];

            adjList.get(u).add(v);
            indegree[v]++;
        }
    }
}
