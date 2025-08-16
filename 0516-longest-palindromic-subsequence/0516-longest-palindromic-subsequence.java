class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        return longest(s, str.reverse().toString());
    }
    public static int longest(String s1, String s2){
        int[] prev = new int[s2.length() + 1];
        for(int i = 1; i <= s1.length(); i++){
            int[] curr = new int[s2.length() + 1];
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[s1.length()];
    }
}