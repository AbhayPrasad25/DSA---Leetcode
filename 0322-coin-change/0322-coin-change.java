class Solution {
    public int coinChange(int[] coins, int amount) {
        //tabulation
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }
            else{
                dp[0][i] = (int)1e9;
            }
        }
        for(int i = 1; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                int take = (int)1e9;
                if(coins[i] <= j){
                    take = 1 + dp[i][j - coins[i]];
                }
                int notTake = dp[i - 1][j];
                dp[i][j] = Math.min(take, notTake);
            }
        }
        if(dp[coins.length - 1][amount] >= (int)1e9){
            return -1;
        }
        return dp[coins.length - 1][amount];
    }
    public int minCoins(int index, int[] coins, int amount, int[][] dp){
        if(index == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }
            else{
                return Integer.MAX_VALUE - 1;
            }
        }
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int take = Integer.MAX_VALUE - 1;
        if(coins[index] <= amount){
            take = 1 + minCoins(index, coins, amount - coins[index], dp);
        }
        int notTake = minCoins(index - 1, coins, amount, dp);
        dp[index][amount] = Math.min(take, notTake);
        return  dp[index][amount];
    }
}