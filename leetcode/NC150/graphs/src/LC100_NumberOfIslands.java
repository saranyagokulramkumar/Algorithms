/*
Q-https://leetcode.com/problems/number-of-islands/description/
**Approaches**
1. DFS
* Loop row from 0 to number of rows
* Loop col from 0 to number of cols
* if grid[row][col] is '1' then we start dfs on this cell and increment the island count
* Within the recursive dfs function: base case - if row or col exceed boundaries or grid[row][col] is 0 or if current cell is already visited we return
* mark visited[row][col] as true and call dfs on all four directions recursively
* return num of islands from main function

*Time complexity* - O(M×N) where M is the number of rows and N is the number of columns.
*Space complexity* - worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.

2. BFS
* Loop from row 0 to number of rows
* Loop from col 0 to number of cols
* if grid[row][col] is '1' then do the following
* increment island count
* create a new neighbours queue to keep track of the neighbours on the current island ( this needs to be new for every island, so initializing it here will wipe it for the next iteration of for loop
* add the current row,col value as row * cols + col in the queue
* Now while q is not empty, poll each neighbor get the row and col value as neighbor / cols and neighbor % cols
* use a helper function to validate all four directions of rows and cols and add it to the neighbor queue if valid index and grid[row][col] is 1 and not visited[row][col]
* return number of islands

*Time complexity* - O(MxN)
*Space complexity* - O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).

 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC100_NumberOfIslands {
    public int numIslandsDFS(char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[rows][cols];

        if(rows == 0 && cols == 0)return islands;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    islands++;
                    dfs(grid, row, col, visited);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == '0')return;

        visited[row][col] = true;
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }

    public int numIslandsBFS(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[rows][cols];

        if (rows == 0 && cols == 0) return islands;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    islands++;
                    Queue<Integer> neighbours = new LinkedList<>();
                    neighbours.add(row * cols + col);

                    while (!neighbours.isEmpty()) {
                        int neighbour = neighbours.poll();
                        int nrow = neighbour / cols;
                        int ncol = neighbour % cols;
                        visited[nrow][ncol] = true;

                        validateAndAddNeighbour(nrow + 1, ncol, grid, neighbours, visited);
                        validateAndAddNeighbour(nrow - 1, ncol, grid, neighbours, visited);
                        validateAndAddNeighbour(nrow, ncol - 1, grid, neighbours, visited);
                        validateAndAddNeighbour(nrow, ncol + 1, grid, neighbours, visited);
                    }
                }
            }
        }
        return islands;
    }

    private void validateAndAddNeighbour(int row, int col, char[][] grid, Queue<Integer> neighbours, boolean[][] visited){
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' &&
        !visited[row][col]){
            neighbours.add(row * grid[0].length + col);
        }
    }
}
