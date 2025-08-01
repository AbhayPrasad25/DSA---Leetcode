class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] dp1 : dp){
            Arrays.fill(dp1, -1);
        }
        int num = minCoins(coins.length - 1, coins, amount, dp);
        if(num >= Integer.MAX_VALUE - 1){
            return -1;
        }
        return num;
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