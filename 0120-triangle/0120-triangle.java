class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return triangleSum(triangle, 0, 0, dp);
    }
    //recursive approach
    public int triangleSum(List<List<Integer>> triangle , int row, int rowIndex , int[][] dp){
        //base case
        if(row == triangle.size() - 1){
            return triangle.get(row).get(rowIndex);
        }
        if(dp[row][rowIndex] != -1){
            return dp[row][rowIndex];
        }
        int sameIndex = triangle.get(row).get(rowIndex) + triangleSum(triangle, row + 1, rowIndex, dp);
        int nextIndex = Integer.MAX_VALUE;
        if(rowIndex + 1 < triangle.get(row + 1).size()){
            nextIndex = triangle.get(row).get(rowIndex) + triangleSum(triangle, row + 1, rowIndex + 1, dp);
        }
        dp[row][rowIndex] = Math.min(sameIndex , nextIndex);
        return dp[row][rowIndex];
    }
}