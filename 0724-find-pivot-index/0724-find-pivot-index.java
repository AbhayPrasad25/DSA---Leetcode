class Solution {
    public int pivotIndex(int[] nums) {
        int index = -1;
        int[] prefix = new int[nums.length];
        int pref = 0;
        for(int i = 0; i < prefix.length; i++){
            prefix[i] = pref;
            pref += nums[i];
        }
        int suf = 0;
        for(int j = nums.length - 1; j >= 0; j--){
            if(prefix[j] == suf){
                index = j;
            }
            suf += nums[j];
        }
        return index;
    }
}