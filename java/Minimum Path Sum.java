64. Minimum Path Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 80691
Total Submissions: 224020
Difficulty: Medium
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.


设f[i][j]表示从左上角的原点到达grid[i][j]花费的最小代价,
则状态转移方程为 f[i][j]=grid[i][j]+min(f[i-1][j],f[i][j-1])

空间复杂度O(1),时间复杂度O(n^2)
public class Solution {
    public int minPathSum(int[][] grid) {
        int height=grid.length;
        int width=grid[0].length;
        for(int i=1;i<height;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<width;i++){
            grid[0][i]+=grid[0][i-1];
        }
        for(int row=1;row<height;row++){
            for(int col=1;col<width;col++){
                grid[row][col]+=Math.min(grid[row-1][col],grid[row][col-1]);
            }
        }
        return grid[height-1][width-1];
    }
}
