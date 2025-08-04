class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] curr = new int[nums.length + 1];
        int[] prev = new int[nums.length + 1];
        int n = nums.length;
        for(int i = n - 1; i>= 0; i--){
            for(int prevInd = i - 1; prevInd >= -1; prevInd--){
                int take = 0;
                if(prevInd == -1 || nums[i] > nums[prevInd]){
                    take = 1 + prev[i + 1];
                    }
                int notTake = prev[prevInd + 1];
                curr[prevInd + 1] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[-1 + 1];
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
