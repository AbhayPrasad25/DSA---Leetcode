class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(0 , s, res, ans);
        return res;
    }

    public static void backtrack(int index, String s, List<List<String>> res, List<String> ans){
        if(index == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s.substring(index , i+1))){
                ans.add(s.substring(index , i+1));
                backtrack(i+1, s, res, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}