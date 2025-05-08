class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int total1 = 0;
        int maxlen = 0;
        int count = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                count++;
            }
            int size = right - left + 1;
            while(count > k){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}