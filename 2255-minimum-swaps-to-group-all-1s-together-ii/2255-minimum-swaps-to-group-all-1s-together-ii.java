class Solution {
    public int minSwaps(int[] nums) {
        int total1 = 0;
        for(int n : nums){
            total1 += n;
        }
        int n = nums.length;
        int count1 = 0;
        int right = 0;
        int min = nums.length;
        // move the window total1 spaces and count the number of ones 
        for(int i = 0; i < total1; i++){
            count1 += nums[i];
        }
        // now make a left pointer which is toatal1 spaces forward and count the number of ones in circukar way 
        int left = total1;
        while(right < nums.length){
            min = Math.min(min, total1 - count1);
            count1 -= nums[right];
            count1 += nums[(left) % n];
            right++;
            left++;
        }
        return min;
    }
}