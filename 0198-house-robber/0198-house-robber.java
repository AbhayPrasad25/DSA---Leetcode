class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int take = nums[i];
            if(i > 1){
                take += dp[i - 2];
            }
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[nums.length - 1];
    }
    public int maxmoney(int index, int[] nums, int[] dp){
        if(index == 0){
            return nums[index];
        }
        if(index < 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index] + maxmoney(index - 2, nums,dp);
        int notPick = maxmoney(index - 1, nums,dp);
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}