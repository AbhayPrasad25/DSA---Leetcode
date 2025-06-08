class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i< nums.length; i++){
            max = Math.max(nums[i] , max);
        }
        return atmostDistinct(nums, k, max) - atmostDistinct(nums, k - 1, max);
    }
    private int atmostDistinct(int[] nums, int k, int max){
        int left = 0, right = 0;
        int count = 0;
        int distinctCount = 0;
        int[] freq = new int[max + 1];
        while(right < nums.length){
            if(freq[nums[right]] == 0){
                distinctCount++;
            }
            freq[nums[right]]++;
            while(left <= right && distinctCount > k){
                if(freq[nums[left]] == 1){
                    distinctCount--;
                }
                freq[nums[left]]--;
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}