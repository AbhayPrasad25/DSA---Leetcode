class Solution {
    public int[] singleNumber(int[] nums) {
        //The base idea is to get the rightmost bit and do operations on that
        int num = 0;
        for(int n : nums){
            num ^= n;
        }
        //now we will try to place number based on the buckets 
        num = (num ^ num - 1) & num;
        int el1 =0, el2 = 0;
        for(int n : nums){
            if((num & n ) != 0){
                el1 ^= n;
            }
            else{
                el2 ^= n;
            }
        }
        int[] arr = new int[]{el1, el2};
        return arr;
    }
}