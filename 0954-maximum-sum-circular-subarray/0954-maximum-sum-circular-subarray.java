class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxSum = nums[0] , totalSum = nums[0], minSum = nums[0];
        for(int i = 1; i< nums.length; i++){
            maxSum = Math.max(nums[i] , maxSum + nums[i]);
            minSum = Math.min(nums[i] , minSum + nums[i]);
            totalSum += nums[i];
            max = Math.max(max , maxSum);
            min = Math.min(min , minSum);
        }
        // Since both are same means the whole array is full of neg values
        if(totalSum == min){
            return max;
        }
        return Math.max(totalSum - min, max);
    }
}