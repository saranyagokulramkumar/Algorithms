/*
Q-https://leetcode.com/problems/number-of-enclaves/description/
**Approaches**
1. BFS
* init -> visited[][] matrix, Queue<int[]> to store the row, col, landCells = 0
* go through the input matrix, if a cell is a boundarycell (row = 0 or col = 0 or row = rows - 1 or cols = cols - 1) add the cell to the queue, mark it as visited; otherwise if not boundary cell and if grid[row][col] is 1, this is a land cell so increment landCells by 1
* now while the queue is not empty, poll each cell from queue, check in all 4 directions and see if the cell is valid (not exceeding boundary),  has not been visited and grid[row][col] is 1, then mark it as visited, offer the cell to the queue, decrement landCells by 1, cos this one is connected to a boundary cell and therefore we can walk off the boundary of the matrix from this cell.
* return landCells

*Time complexity* - O(MxN) -> each cell is visited once
*Space complexity* - O(MxN) -> for the queue, visited matrix

2. DFS
* init -> visited[][] matrix
* for each row and col, if the cell is a boundary cell and grid[row][col] is 1, invoke DFS with the row, col, grid, visited, directions
* inside the recursive function, mark the cell as visited first, now for all 4 directions, if the row, col is valid and cell has not been visited and grid[row][col] is 1, invoke dfs with the new row col
* in the main function after dfs returns and we have visited all the boundary cells with 1, go through the matrix again to count the number of 1s that haven't been visited and are equal to 1, these are our landCells
* return landCells

*Time complexity* - O(MxN) -> each cell is visited once
*Space complexity* - O(MxN) -> visited matrix, recursive stack in the worst case can be O(MxN)

 */

import java.util.LinkedList;
import java.util.Queue;

public class LC1020_NumberOfEnclaves {
    public int numEnclavesDFS(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(boundaryCell(row,col,rows,cols) && grid[row][col] == 1){
                    dfs(row, col, grid, visited, directions);
                }
            }
        }

        // count number of cells that have 1 and are not visited
        int landCells = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(!visited[row][col] && grid[row][col] == 1){
                    landCells++;
                }
            }
        }
        return landCells;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited, int[][] directions){
        visited[row][col] = true;
        for(int[] direction: directions){
            int nrow = row + direction[0];
            int ncol = col + direction[1];

            if(validRC(nrow,ncol,grid.length,grid[0].length) && !visited[nrow][ncol]
                    && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, visited, directions);
            }
        }
    }

    public int numEnclavesBFS(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int landCells = 0;

        // add all the boundary 1's to the queue (on row 0, col 0, row = rows-1, col = cols -1)
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(boundaryCell(row,col,rows,cols) && grid[row][col] == 1){
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }else if(grid[row][col] == 1){
                    landCells++;
                }
            }
        }

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

        // now BFS
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] direction: directions){
                int nrow = row + direction[0];
                int ncol = col + direction[1];

                if(validRC(nrow,ncol,rows,cols) && !visited[nrow][ncol]
                        && grid[nrow][ncol] == 1){
                    visited[nrow][ncol] = true;
                    queue.offer(new int[]{nrow, ncol});
                    landCells--;
                }
            }
        }
        return landCells;
    }

    private boolean boundaryCell(int row, int col, int rows, int cols){
        if(row == 0 || col == 0 || row == rows - 1 || col == cols - 1){
            return true;
        }
        return false;
    }

    private boolean validRC(int row, int col, int rows, int cols){
        if(row < 0 || col < 0 || row >= rows || col >= cols)return false;
        return true;
    }
}
