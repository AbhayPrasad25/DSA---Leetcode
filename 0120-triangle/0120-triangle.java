class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        int n = triangle.size();
        for(int i = 0; i < n; i++){
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                dp[i][j] = Math.min(dp[i + 1][j] , dp[i+1][j+1]);
                dp[i][j] += triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    //recursive approach
    // public int triangleSum(List<List<Integer>> triangle , int row, int rowIndex , int[][] dp){
    //     //base case
    //     if(row == triangle.size() - 1){
    //         return triangle.get(row).get(rowIndex);
    //     }
    //     if(dp[row][rowIndex] != -1){
    //         return dp[row][rowIndex];
    //     }
    //     int sameIndex = triangle.get(row).get(rowIndex) + triangleSum(triangle, row + 1, rowIndex, dp);
    //     int nextIndex = triangle.get(row).get(rowIndex) + triangleSum(triangle, row + 1, rowIndex + 1, dp);
    //     dp[row][rowIndex] = Math.min(sameIndex , nextIndex);
    //     return dp[row][rowIndex];
    // }
} 