class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        backtrack(0, ans, res, s);
        return ans;
    }
    private void backtrack(int index, List<List<String>> ans, List<String> res, String s){
        //base case
        if(index == s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int end = index; end < s.length(); end++){
            if(isPalindrome(s.substring(index , end + 1))){
                res.add(s.substring(index , end + 1));
                backtrack(end + 1, ans, res, s);
                res.remove(res.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}