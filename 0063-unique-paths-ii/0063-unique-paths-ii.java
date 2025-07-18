class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m  = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[i] += dp[i-1];
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }

                if(j == 0){
                    continue;
                }
                int sum = dp[j] + dp[j-1];
                dp[j] = sum;
            }
        }
        return dp[n-1];
    }
}