class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //dynamic sliding window approach 
        return atMostOdd(nums, k) - atMostOdd(nums, k - 1);
    }
    public int atMostOdd(int[] nums, int k){
        int left = 0;
        int right = 0;
        int count = 0;
        int odd = 0;
        while(right < nums.length){
            if(nums[right] % 2 != 0){
                odd++;
            }
            while(left <= right && odd > k){
                if(nums[left] % 2 != 0){
                    odd--;
                }
                left++;
            }
            count += right - left;
            right++;
        }
        return count;
    }
}