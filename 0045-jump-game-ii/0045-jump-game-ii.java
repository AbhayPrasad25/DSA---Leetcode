class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return minJump(0, nums, dp);
    }
    //recursive approach
    public int minJump(int index , int[] nums, int[] dp){
        if(index >= nums.length -1){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int min = nums.length;
        for(int i = 1; i <= nums[index]; i++){
            if(index + i < nums.length){
                min = Math.min(min , 1 + minJump(index + i, nums, dp));
            }
        }
        dp[index] = min;
        return dp[index];
    }
}