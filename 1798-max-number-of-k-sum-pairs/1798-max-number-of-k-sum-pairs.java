class Solution {
    public int maxOperations(int[] nums, int k) {
        // Better Approach sorting and two pointers
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int operation = 0;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == k){
                operation += 1;
                left++;
                right--;
            }
            else if(sum < k){
                left++;
            }
            else{
                right--;
            }
        }
        return operation;
    }
}