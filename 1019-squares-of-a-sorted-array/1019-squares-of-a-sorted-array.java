class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left =0;
        int right = nums.length - 1;
        int ptr = nums.length - 1;
        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[ptr--] = nums[left] * nums[left];
                left++;
            }
            else{
                res[ptr--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}