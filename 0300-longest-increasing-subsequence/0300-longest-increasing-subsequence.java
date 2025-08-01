class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] dp1 : dp){
            Arrays.fill(dp1 , -1);
        }
        return recurseLis(0, nums, -1, dp);
    }
    public int recurseLis(int index, int[] nums, int prev, int[][] dp){
        if(index == nums.length){
            return 0;
        }
        if(dp[index][prev + 1] != -1){
            return dp[index][prev + 1];
        }
        int take = Integer.MIN_VALUE;
        if(prev == -1 || nums[index] > nums[prev]){
            take = 1 + recurseLis(index + 1, nums, index, dp);
        }
        int notTake = recurseLis(index + 1, nums, prev, dp);
        dp[index][prev + 1] = Math.max(take, notTake);
        return dp[index][prev + 1];
    }
}