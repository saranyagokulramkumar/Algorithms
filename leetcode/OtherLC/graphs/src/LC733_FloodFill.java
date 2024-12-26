/*
Q-https://leetcode.com/problems/flood-fill/description/
**Approach**
DFS
1. clone the image to not tamper with the input
2. store the current color of the source cell
3. check if current color is already equal to newcolor, in that case return the image as is
4. call dfs on the clone, srow, scol, currentcolor, newcolor
5. in the recursive function - base case: if row or col exceeds boundary or the color in cell is not equal to currentColor, return
6. change the color of cell to newcolor
7. call dfs on all 4 directions
8. return clone

*Time complexity* - O(NxM) -> N is the number of rows and M is the number of cols, each cell is processed once
*Space complexity* - O(NxM) -> worst case when entire grid is of the same color as source, we will have these many calls on recursive call stack
 */
public class LC733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if(currentColor == newColor)return image;

        int[][] clone = cloneImage(image);
        dfs(clone, sr, sc, currentColor, newColor);

        return clone;
    }

    private void dfs(int[][] clone, int row, int col, int currentColor, int newColor){
        if(row < 0 || row >= clone.length || col < 0
                || col >= clone[0].length || clone[row][col] != currentColor)return;

        clone[row][col] = newColor;

        dfs(clone, row + 1, col, currentColor, newColor);
        dfs(clone, row - 1, col, currentColor, newColor);
        dfs(clone, row, col + 1, currentColor, newColor);
        dfs(clone, row, col - 1, currentColor, newColor);

    }

    private int[][] cloneImage(int[][] image){
        int rows = image.length;
        int cols = image[0].length;

        int[][] clone = new int[rows][cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                clone[row][col] = image[row][col];
            }
        }
        return clone;
    }
}
