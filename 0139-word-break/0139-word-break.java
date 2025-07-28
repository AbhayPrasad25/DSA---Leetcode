class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return canBeMade(0,s, wordDict, set, memo);
    }
    public static boolean canBeMade(int index,String s, List<String> wordDict, HashSet<String> set, Boolean[] memo){
        //base case
        if(index >= s.length()){
            return true;
        }
        if(memo[index] != null){
            return memo[index];
        }
        boolean res = false;
        for(int i = index; i < s.length(); i++){
            if(set.contains(s.substring(index , i+1))){
                res =  res || canBeMade(i+1, s, wordDict, set, memo);
            }
        }
        memo[index] = res;
        return memo[index];
    }
}