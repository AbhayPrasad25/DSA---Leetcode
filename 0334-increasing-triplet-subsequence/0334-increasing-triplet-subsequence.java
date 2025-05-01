class Solution {
    public boolean increasingTriplet(int[] nums) {
        // My First priority should be checking consecutive indices since it asks to solve in O(n) time
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < second && nums[i] < first){
                first = nums[i];
            }
            else if(nums[i] > first && nums[i] < second){
                second = nums[i];
            }
            if(nums[i] > second){
                return true;
            }

        }
        return false;
    }
}