class Solution {
    public int rob(int[] nums) {
        //this question is similar to the house robber 1 but the only differnec is thw houses are in a circular way
        if(nums.length == 1){
            return nums[0];
        }
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        int[] dp1 = new int[arr1.length];
        int[] dp2 = new int[arr2.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                arr1[i - 1] = nums[i];
            }
            if(i != nums.length - 1){
                arr2[i] = nums[i];
            }
        }
        return Math.max(houseRobbing(arr1 , arr1.length - 1, dp1), houseRobbing(arr2, arr2.length - 1, dp2));
    }
    public int houseRobbing(int[] nums, int index, int[] dp){
        if(index == 0){
            return nums[index];
        }
        if(index < 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int take = nums[index] + houseRobbing(nums, index-2, dp);
        int notTake = houseRobbing(nums, index - 1, dp);
        dp[index] = Math.max(take, notTake);
        return dp[index];
    }

}