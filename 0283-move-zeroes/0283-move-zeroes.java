class Solution {
    public void moveZeroes(int[] nums) {
        // Optimal Approach
        // Fast pointer always moves and slow pointer keeps track of non zero and swaps to next non zero
        int fast = 0;
        int slow = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
    }
}