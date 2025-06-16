class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        backtrack(res, ans, 0, nums, set);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> ans, int index, int[] nums, HashSet<List<Integer>> set){
        if(index >= nums.length){
            if(!set.contains(ans)){
                res.add(new ArrayList<>(ans));
                set.add(ans);
            }
            return;
        }
        ans.add(nums[index]);
        backtrack(res, ans, index + 1, nums, set);
        ans.remove(ans.size() - 1);
        backtrack(res, ans, index + 1, nums, set);
    }
}