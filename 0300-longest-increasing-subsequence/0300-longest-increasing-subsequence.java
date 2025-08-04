class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , 1);
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
               if(nums[j] < nums[i]){
                dp[i] = Math.max(dp[i] , 1 + dp[j]);
               }
            }
            max = Math.max(dp[i] , max);
        }
        return max;
    }

    public int recurseLis(int index, int[] nums, int prev, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }
        int take = Integer.MIN_VALUE;
        if (prev == -1 || nums[index] > nums[prev]) {
            take = 1 + recurseLis(index + 1, nums, index, dp);
        }
        int notTake = recurseLis(index + 1, nums, prev, dp);
        dp[index][prev + 1] = Math.max(take, notTake);
        return dp[index][prev + 1];
    }
}
