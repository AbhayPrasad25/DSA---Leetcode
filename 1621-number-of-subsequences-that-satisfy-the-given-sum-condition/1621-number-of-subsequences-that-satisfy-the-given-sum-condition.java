class Solution {
    public int numSubseq(int[] nums, int target) {
        int modulo = 1000000007;
        Arrays.sort(nums);
        int[] powers = new int[nums.length];
        int pow = 1;
        for(int i = 0; i < powers.length; i++){
            powers[i] = pow;
            pow = pow * 2 % modulo;
        }
        int left = 0, right = nums.length - 1;
        int res = 0;
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                res += powers[right - left];
                res %= modulo;
                left++;
            }
            else if(nums[left] + nums[right] > target){
                right--;
            }
        }
        return res % modulo;
    }
}