class Solution {
    public int singleNumber(int[] nums) {
        //Optimal approach based on buckets making buckets of 1 and 2 and storing them 
        int one = 0, two = 0;
        for(int n : nums){
            one = (one ^ n) & ~two;
            two = (two ^ n) & ~one;
        }
        return one;
    }
}