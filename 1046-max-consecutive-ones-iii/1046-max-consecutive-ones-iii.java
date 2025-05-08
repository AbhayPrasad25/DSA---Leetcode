class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxlen = 0;
        int count = 0;
        while(right < nums.length){
            count += (1 - nums[right]);
            while(count > k){
                count -= (1 - nums[left]);
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}
