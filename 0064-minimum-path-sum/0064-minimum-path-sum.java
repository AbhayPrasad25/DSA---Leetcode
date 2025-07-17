class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                int right = grid[i][j] + dp[i-1][j];
                int down = grid[i][j] + dp[i][j -1];
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
    //Recursion + memoization
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