class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //optimal 
        return slideApproach(nums, goal) - slideApproach(nums, goal - 1);
    }
    private int slideApproach(int[] nums, int goal){
        int left = 0, right = 0;
        int count = 0, sum = 0;
        while(right < nums.length){
            if(sum < 0){
                return 0;
            }
            sum += nums[right];
            while(left <= right && sum > goal){
                sum -= nums[left];
                left++;
            }
            count += right - left;
            right++;
        }
        return count;
    }
}