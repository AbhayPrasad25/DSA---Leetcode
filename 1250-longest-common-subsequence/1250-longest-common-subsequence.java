class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return longestCommon(text1.length(),text2.length(), text1, text2, dp);
    }
    public static int longestCommon(int index1, int index2, String text1, String text2, int[][] dp){
        if(index1 == 0 || index2 == 0){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        } 
        int matches = 0;
        if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)){
            matches = 1 + longestCommon(index1 - 1, index2 - 1, text1, text2, dp);
        }
        int notMatches = Math.max(longestCommon(index1 - 1, index2, text1, text2, dp), longestCommon(index1, index2 - 1, text1, text2, dp));
        dp[index1][index2] =Math.max(matches , notMatches);
        return dp[index1][index2];
    }
}