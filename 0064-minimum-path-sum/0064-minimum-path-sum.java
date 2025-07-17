class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] d : dp){
            Arrays.fill(d , - 1);
        }
        return minPath(grid, grid.length - 1, grid[0].length - 1, dp);
    }
    public int minPath(int[][] grid, int i , int j, int[][] dp){
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        int rightPath = minPath(grid, i-1, j, dp);
        if(rightPath != Integer.MAX_VALUE){
            min = Math.min(min, grid[i][j] + rightPath);
        }
        int downPath = minPath(grid, i , j - 1, dp); 
        if(downPath != Integer.MAX_VALUE){
            min = Math.min(min, grid[i][j] + downPath);
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}