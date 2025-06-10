class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permut(0, nums, res, ans, used);
        return ans;
    }
    private void permut(int index, int[] nums, List<Integer> res, List<List<Integer>> ans, boolean[] used){
        if(res.size() == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            else{
                res.add(nums[i]);
                used[i] = true;
                permut(index + 1, nums, res, ans, used);
                res.remove(res.size() - 1);
                used[i] = false;
            }
        }
    }
}