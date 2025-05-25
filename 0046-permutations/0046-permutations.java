class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        generate(res, perm, nums);
        return res;
    }
    private void generate(List<List<Integer>> res, List<Integer> perm, int[] nums){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return ;
        }
        for(int num : nums){
            if(perm.contains(num)){
                continue;
            }
            perm.add(num);
            generate(res, perm, nums);
            perm.remove(perm.size() - 1);
        }
    }
}