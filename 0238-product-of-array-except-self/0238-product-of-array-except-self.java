class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefsuf = new int[nums.length];
        int suf = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            prefsuf[i] = suf;
            suf *= nums[i];
        }
        //Now calculating the prefix and updating the previously made suffix array
        int pref = 1;
        for(int i = 0; i < nums.length; i++){
            prefsuf[i] *= pref;
            pref *= nums[i];
        }
        return prefsuf;
    }
}