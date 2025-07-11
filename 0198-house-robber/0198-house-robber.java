class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxmoney(nums.length - 1, nums, dp);
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