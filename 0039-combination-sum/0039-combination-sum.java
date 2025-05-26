class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        generate(res, comb, candidates, target, 0);
        return res;
    }

    private void generate(List<List<Integer>> res, List<Integer> comb, int[] nums, int rem, int index) {
        if (rem == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i] > rem){
                break;
            }
            comb.add(nums[i]);
            generate(res, comb, nums, rem - nums[i], i);
            comb.remove(comb.size() - 1);
        }
    }
}