class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo , -1);
        int res = dfs(coins, amount,memo);
        return (res == Integer.MAX_VALUE ? -1 : res);
    }
    public int dfs(int[] coins, int amount, int[] memo){
        if(amount == 0){
            return 0;
        }
        if(amount > 0 && memo[amount] != -1){
            return memo[amount];
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dfs(coins, amount - coin, memo);
            if(res == Integer.MAX_VALUE){
                continue;
            }
            ans = Math.min(ans, res + 1);
        }
        return memo[amount] = ans;
    }
}