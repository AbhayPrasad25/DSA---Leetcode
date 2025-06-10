class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        permut(0, nums, res, ans);
        return ans;
    }
    private void permut(int index, int[] nums, List<Integer> res, List<List<Integer>> ans){
        if(index >= nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!res.contains(nums[i])){
                res.add(nums[i]);
                permut(index + 1, nums, res, ans);
                res.remove(res.size() - 1);
            }
        }
    }
}