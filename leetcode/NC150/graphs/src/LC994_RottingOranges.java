import java.util.LinkedList;
import java.util.Queue;

/*
Q-https://leetcode.com/problems/rotting-oranges/description/
**Approach**
BFS
* Create a queue to hold a Pair of integers for the row and col of a cell
* Add all the cells that are initially 2 in the grid, inside the same loop count the number of freshoranges
* if number of freshoranges are already 0, return 0
* now while the queue is not empty, get the queue.size which will give us the number of nodes in the current level. We have to process all of these nodes in a given minute
* run a for loop for the number of nodes obtained above
* poll a value, get the row col. Now for each of the 4 directions, check if the neighbor is valid (row and col don't cross boundary and grid[row][col] = 1), if valid then we rot the orange (set value to 2), add the new row and col to the queue, decrement the number of freshoranges and set the flag hasRotten to true to denote that at this level there were oranges that got rotten
* if hasrotten is true, only then increment the number of minutes
* At the end check if there are 0 freshoranges, if yes return minutes, else return -1

*Time complexity* - O(MxN)
*Space complexity* - O(MxN)
 */
public class LC994_RottingOranges {
    public int orangesRotting(int[][] grid){
        int minutes = 0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;

        // add all rotten oranges to the queue
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 2){
                    queue.offer(new Pair<>(row, col));
                }else if(grid[row][col] == 1){
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0)return 0; // no fresh oranges to rot

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // process each level of rotten oranges
        while(!queue.isEmpty()){
            int totalOranges = queue.size();
            boolean hasRotten = false;

            for(int orange = 0; orange < totalOranges; orange++){
                // process neighbors of each orange and add to queue
                Pair<Integer, Integer> pair = queue.poll();
                int row = pair.getKey();
                int col = pair.getValue();

                // validate neighbors and rot them and add to queue
                for(int[] direction : directions){
                    int nrow = row + direction[0];
                    int ncol = col + direction[1];

                    if(validNeighbor(nrow, ncol, grid)){
                        grid[nrow][ncol] = 2;
                        queue.offer(new Pair<>(nrow, ncol));
                        freshOranges--;
                        hasRotten = true;
                    }
                }
            }
            if(hasRotten){
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }

    private boolean validNeighbor(int row, int col, int[][] grid){
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length &&
                grid[row][col] == 1)return true;

        return false;
    }
}
