class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // to optimze the size issue we can store the result of repeated index and check if it matches 
        String str = "";
        Boolean[] memo = new Boolean[s.length()];
        return backtrack(s, 0, wordDict, memo);
    }
    private boolean backtrack(String s, int index, List<String> wordDict, Boolean[] memo){
        if(index == s.length()){
            return true;
        }
        if(memo[index] != null){
            return memo[index];
        }
        for(String word : wordDict){
            //checks every prefix and checks if the substring starts with the word and if it starts we call to check if the next substring contains any word in the wordDict
            if(s.substring(index).startsWith(word)){
                if(backtrack(s, index + word.length() , wordDict, memo)){
                    memo[index] = true;
                    return true;
                }
            }
            memo[index] = false;
        }
        return false;
    }
}