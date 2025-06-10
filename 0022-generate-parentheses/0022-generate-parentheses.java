class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String str = "";
        generate(0, 0 , n, ans, str);
        return ans;
    }
    private void generate(int open, int close , int n , List<String> ans, String str){
        if(open == n && close == n){
            ans.add(str);
            return;
        }
        if(open < n){
            generate(open + 1, close, n, ans, str + "(");
        }
        if(close < open){
            generate(open , close + 1, n , ans, str + ")");
        }
    }
}