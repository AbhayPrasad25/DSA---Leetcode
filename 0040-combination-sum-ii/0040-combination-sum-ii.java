class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        backtrack(candidates, target,0,0, res, ans , used);
        return res;
    }
    public void backtrack(int[] nums, int target, int sum, int index, List<List<Integer>> res , List<Integer> ans, boolean[] used){
        if(sum == target){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(sum + nums[i] > target){
                break;
            }
            if(i > index && nums[i - 1] == nums[i]){
                continue;
            }
            if(used[i] == false){
                ans.add(nums[i]);
                used[i] = true;
                backtrack(nums, target, sum + nums[i], i + 1, res, ans, used);
                ans.remove(ans.size() - 1);
                used[i] = false;
            }
        }
    }
}