class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(ans, res, nums, 0, used);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> res, int[] nums, int index, boolean[] used){
        if(index == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            res.add(nums[i]);
            used[i] = true;
            backtrack(ans, res, nums, index + 1, used);
            used[i] = false;
            res.remove(res.size() - 1);
        }
    }
}