import java.util.LinkedList;
import java.util.Queue;

/*
Q-https://leetcode.com/problems/01-matrix/description/
**Approach**
BFS
* create a queue that will hold the row, col pair for cells
* initially add the cells that hold a 0 to the queue, simultaneously marking them as visited in the visited[][] boolean matrix
* init dist to 1, cos all cells with a 0 have a 0 distance to the neighboring 0 which is themselves, now we start from distance = 1 for the neighbors
* now while the queue is not empty, poll all pairs at this level and run a for loop and check all 4 directions
* if the nrow,ncol in the four directions is valid (not crossing boundary) and has not been visited, add the pair to the queue, mark it as visited and set the distance[nrow][ncol] to dist (all cells in this level have a distance = dist
* now after processing all nodes in the level increment dist by 1
* the nodes in the queue if any will now be at a distance of dist+1 from the previous level
* return distance matrix

*Time complexity* - O(MxN) -> all cells are processed once by BFS
*Space complexity* - O(MxN) -> to store the visited and the distance matrix and same for the queue if all cells have a 0
 */
public class LC542_01Matrix {
    private boolean validRC(int row, int col, int n, int m){
        return 0 <= row && row < n && 0 <= col && col < m;
    }

    public int[][] updateMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();

        // add all the 0's to the matrix
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(matrix[row][col] == 0){
                    queue.offer(new Pair<>(row, col));
                    visited[row][col] = true;
                    distance[row][col] = 0;
                }
            }
        }

        int[][] directions = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
        int dist = 1;

        // now BFS
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int cell = 0; cell < size; cell++){
                Pair<Integer,Integer> pair = queue.poll();
                int row = pair.getKey();
                int col = pair.getValue();

                for(int[] direction : directions){
                    int nrow = row + direction[0];
                    int ncol = col + direction[1];
                    if(validRC(nrow, ncol, rows, cols) && !visited[nrow][ncol]){
                        queue.offer(new Pair<>(nrow, ncol));
                        distance[nrow][ncol] = dist;
                        visited[nrow][ncol] = true;
                    }
                }
            }
            dist++;
        }
        return distance;
    }
}
