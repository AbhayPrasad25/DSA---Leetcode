class Solution {
    public List<String> generateParenthesis(int n) {
        String cur = "";
        List<String> ans = new ArrayList<>();
        generate(cur, 0, 0, ans, n);
        return ans;
    }
    private static void generate(String current,int open, int close, List<String> ans, int n){
        // base case
        if(current.length() >= 2 * n){
            ans.add(current);
            return;
        }
        // since at max we can have 3 open brackets
        if(open < n){
            generate(current + "(", open + 1, close, ans, n);
        }
        // to add closing brackets after we have added all the closing brackets
        if(close < open){
            generate(current + ")", open, close + 1, ans, n);
        }

    }
}