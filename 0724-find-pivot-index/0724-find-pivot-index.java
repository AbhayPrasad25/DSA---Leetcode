class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int a : nums){
            total += a;
        }
        int left = 0;
        for(int j = 0; j < nums.length; j++){
            int right = total - left - nums[j];
            if(left == right){
                return j;
            }
            left += nums[j];
        }
        return -1;
    }
}