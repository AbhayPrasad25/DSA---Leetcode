class Solution {
    public int rob(int[] nums) {
        //this question is similar to the house robber 1 but the only differnec is thw houses are in a circular way
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        //mainly for the house from start excluding the last
        for(int i = 1; i < nums.length - 1; i++){
            int take = nums[i];
            if(i > 1){
                take += dp[i - 2];
            }
            int nottake = dp[i-1];
            dp[i] =  Math.max(take, nottake);
        }
        return Math.max(dp[dp.length - 1], houseRobbing(nums));
    }
    public int houseRobbing(int[] nums){
        //for houses from the last but exclduing the first
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            int take = nums[i];
            if(i > 2){
                take += dp[i - 2];
            }
            int nottake = dp[i-1];
            dp[i] =  Math.max(take, nottake);
        }
        return dp[dp.length - 1]; 
        // if(index == 0){
        //     return nums[index];
        // }
        // if(index < 0){
        //     return 0;
        // }
        // if(dp[index] != -1){
        //     return dp[index];
        // }
        // int take = nums[index] + houseRobbing(nums, index-2, dp);
        // int notTake = houseRobbing(nums, index - 1, dp);
        // dp[index] = Math.max(take, notTake);
        // return dp[index];
    }

}