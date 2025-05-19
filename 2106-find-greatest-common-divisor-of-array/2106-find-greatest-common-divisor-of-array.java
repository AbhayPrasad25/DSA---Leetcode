class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int num : nums){
            max = Math.max(max , num);
            min = Math.min(min , num);
        }
        int n = 1;
        int number = 1;
        while(n <= min){
            if(max % n == 0 && min % n == 0){
                number = n;
            }
            n++;
        }
        return number;
    }
}