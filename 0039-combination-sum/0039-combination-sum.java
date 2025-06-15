class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> ans = new ArrayList<>();
        backtrack(candidates, target, ans, res, 0, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<Integer> ans, List<List<Integer>> res, int sum,
            int index) {
        if (sum == target) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum > target) {
                break;
            }
            ans.add(candidates[i]);
            backtrack(candidates, target, ans, res, sum + candidates[i], i);
            ans.remove(ans.size() - 1);
        }
    }
}