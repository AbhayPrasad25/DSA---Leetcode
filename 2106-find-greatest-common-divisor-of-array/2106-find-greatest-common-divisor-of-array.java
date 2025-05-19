class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int num : nums){
            max = Math.max(max , num);
            min = Math.min(min , num);
        }
        while(max % min != 0){
            int rem = max % min;
            max = min;
            min = rem;
        }
        return min;
    }
}