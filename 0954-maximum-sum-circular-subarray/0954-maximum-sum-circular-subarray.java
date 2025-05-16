class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int curSum = 0 , totalSum = 0, minSum = 0;
        for(int num : nums){
            curSum = Math.max(num , curSum + num);
            minSum = Math.min(num , minSum + num);
            totalSum += num;
            max = Math.max(max , curSum);
            min = Math.min(min , minSum);
        }
        // Since both are same means the whole array is full of neg values
        if(totalSum == min){
            return max;
        }
        return Math.max(totalSum - min, max);
    }
}