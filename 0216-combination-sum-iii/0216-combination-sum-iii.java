class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> ans =  new ArrayList<>();
        backtrack(k, n, res, ans, 0, 1);
        return res;
    }
    public void backtrack(int k, int n, List<List<Integer>> ans , List<Integer> res, int sum, int index){
        if(res.size() == k && sum == n){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = index; i <= 9; i++){
            res.add(i);
            backtrack(k, n, ans, res, sum + i, i + 1);
            res.remove(res.size() - 1);
        }
    }
}