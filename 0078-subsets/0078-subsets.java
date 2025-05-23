class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        possible(0, ans, subset, nums);
        return ans;
    }
    private void possible(int i, List<List<Integer>> ans, List<Integer> subset, int[] nums){
        //Base case whenver the index crosses the length of the array we append the list in the ans list
        if(i >= nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        // we need to handle the cases when we add the first element
        subset.add(nums[i]);
        //move to the next index
        possible(i+1, ans, subset, nums);
        //when we have added all the elements in the arraylist we need to remove one at a time and move the next index
        subset.remove(subset.size() - 1);
        //again move to next index to find the possible cases
        possible(i+1, ans, subset, nums);
    }
}