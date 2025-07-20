class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        for(int i : nums){
            sum1 += i;
        }
        if(sum1 % 2 != 0){
            return false;
        }
        sum1 /= 2;
        Boolean[][] dp = new Boolean[n][sum1 + 1];
        return equalSubset(n - 1, nums, sum1, dp);
    }
    public boolean equalSubset(int index, int[] arr, int sum1, Boolean[][] dp){
        if(index == 0){
            return sum1 == 0 || sum1 - arr[index] == 0;
        }
        if(sum1 == 0){
            return true;
        }
        if(dp[index][sum1] != null){
            return dp[index][sum1];
        }
        boolean take = false;
        if(arr[index] <= sum1){
            take = equalSubset(index - 1, arr, sum1 - arr[index],dp);
        }
        boolean notTaken = equalSubset(index - 1, arr, sum1, dp);
        dp[index][sum1] = take || notTaken;
        return dp[index][sum1];
    }
}