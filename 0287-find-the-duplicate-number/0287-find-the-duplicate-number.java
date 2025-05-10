class Solution {
    public int findDuplicate(int[] nums) {
        //Brute force - iterate the array for each element and check if contains the same element
        //better approach - sort the array and check if the any of 2 consecutive pairs are same 
        Arrays.sort(nums);
        int repeat = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                repeat = nums[i];
                break;
            }
        }
        return repeat;
        //Optimal approach - use xor operation to find the repeated element 
    }
}