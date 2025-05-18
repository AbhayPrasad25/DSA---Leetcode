class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //first mark all the negs as 0
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            if(num <= n){
                nums[num - 1] = - Math.abs(nums[num - 1]);
            }
        }
        for(int j = 0 ;j < n; j++){
            if(nums[j] > 0){
                return j + 1;
            }
        }
        return n + 1;
    }
}