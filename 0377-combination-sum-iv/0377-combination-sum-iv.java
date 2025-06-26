class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return backtrack(nums, target, 0 , 0, memo);
    }
    public int backtrack(int[] nums, int target, int index, int sum, int[] memo){
        if(sum == target){
            return 1;
        }
        if(sum > target){
            return 0;
        }
        if(memo[sum] != -1){
            return memo[sum];
        }
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            cnt += backtrack(nums, target, i, sum + nums[i], memo);
        }
        memo[sum] = cnt;
        return cnt;
    }
}