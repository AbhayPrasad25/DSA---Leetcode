class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        //atleast we will do one jump from the firstIndex
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++){
            //all possible jumps we can do from each index
            int min = n;
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    min = Math.min(min , dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
    //recursive approach
    public int minJump(int index , int[] nums, int[] dp){
        if(index >= nums.length -1){
            return 0;
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