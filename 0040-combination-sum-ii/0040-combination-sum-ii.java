class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        backtrack(candidates, target, 0, 0, res, ans);
        return res;
    }

    public void backtrack(int[] nums, int target, int sum, int index, List<List<Integer>> res, List<Integer> ans) {
        if (sum == target) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            ans.add(nums[i]);
            backtrack(nums, target, sum + nums[i], i + 1, res, ans);
            ans.remove(ans.size() - 1);
        }
    }
}