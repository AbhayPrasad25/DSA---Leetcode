class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        int pr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                pr++;
            }
            prefix[i + 1] = pr;
        }
        //Applying binary search to find the first starting point
        int maxlen = 0;
        for(int right = 0; right < nums.length; right++){
            int left = 0, r = right + 1;
            while(left < r){
                int mid = left + (r - left)/2;
                int zero = prefix[right + 1] - prefix[mid];
                if(zero <= k){
                    r = mid;
                }
                else{
                    left = mid + 1;
                }
            }
            //Since left is the leftmost valid start
            maxlen = Math.max(right - left + 1, maxlen);
        }
        return maxlen;
    }
}