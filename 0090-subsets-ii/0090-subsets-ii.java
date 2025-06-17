class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, ans, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> ans, int[] nums, int index) {
        res.add(new ArrayList<>(ans));
        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            ans.add(nums[i]);
            backtrack(res, ans, nums, i+1);
            ans.remove(ans.size() - 1);
        }
    }
}