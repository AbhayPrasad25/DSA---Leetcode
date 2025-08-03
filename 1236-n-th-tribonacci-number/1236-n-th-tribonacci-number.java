class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return recurse(n , dp);
    }
    public static int recurse(int n , int[] dp){
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = recurse(n-3, dp) + recurse(n - 2, dp) + recurse(n - 1, dp);
        return dp[n];
    }
}