class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Neither consecuitve indices worked nether brute worked due to constrains so i greedily selected the fisrt and second so that the at every index either thr first the smallest is selected and in next iteration the second smallest is selected and finally we get a element which is far greater than the first and second an we return true
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= first){
                first = nums[i];
            }
            else if(nums[i] <= second){
                second = nums[i];
            }
            else{
                //The next element is greater we return true
                return true;
            }
        }
        return false;
    }
}