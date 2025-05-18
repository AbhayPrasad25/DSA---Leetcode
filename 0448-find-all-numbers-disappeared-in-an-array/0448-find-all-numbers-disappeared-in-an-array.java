class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set1.add(i+1);
            set2.add(nums[i]);
        }
        for(int num : set1){
            if(!set2.contains(num)){
                res.add(num);
            }
        }
        return res;
    }
}