class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] d : dp){
            Arrays.fill(d , -1);
        }
        return paths(m, n, dp);
    }
    public int paths(int m , int n, int[][] dp){
        if(m == 1 && n == 1){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int moveright = 0;
        int moveDown = 0;
        if(m > 1){
            moveright = paths(m - 1, n, dp);
        }
        if(n > 1){
            moveDown = paths(m, n - 1,dp);
        }
        dp[m][n] = moveright + moveDown;
        return dp[m][n];
    }
}