class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        generate(res, perm , nums, visited);
        return res;
    }

    private void generate(List<List<Integer>>  res , List<Integer> perm, int[] nums, boolean[] visited){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1]){
                continue;
            }
            visited[i] = true;
            perm.add(nums[i]);
            generate(res , perm, nums, visited);
            perm.remove(perm.size() - 1);
            visited[i] = false;
        }
    }
}