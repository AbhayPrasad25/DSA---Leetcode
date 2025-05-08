class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int left = 0, right = 0;
        int maxlen = 0;
        while(right < nums.length){
            count += (1 - nums[right]);
            while(count > 1){
                count -= (1 - nums[left]);
                left++;
            }
            maxlen = Math.max(maxlen , right - left);
            right++;
        }
        return maxlen;
    }
}