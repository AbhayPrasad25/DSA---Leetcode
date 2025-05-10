class Solution {
    public int findDuplicate(int[] nums) {
        //Brute force - iterate the array for each element and check if contains the same element
        //better approach - sort the array and check if the any of 2 consecutive pairs are same 
        //Optimal approach - using floyds tortoise and hare algorithm
        int fast = nums[0];
        int slow = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        // now we reset one pointer to starting point
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}