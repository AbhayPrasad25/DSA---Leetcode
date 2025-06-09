class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        subset(0, nums, ans, res);
        return ans;
    }
    private void subset(int index, int[] nums, List<List<Integer>> ans, List<Integer> res){
        if(index >= nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[index]);
        subset(index + 1, nums, ans, res);
        res.remove(res.size() - 1);
        subset(index + 1, nums, ans, res);
    }
}