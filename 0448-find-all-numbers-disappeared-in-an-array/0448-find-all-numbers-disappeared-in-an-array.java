class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int ind = Math.abs(nums[i]);
            if(nums[ind - 1] < 0){
                continue;
            }
            nums[ind - 1] *= -1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}