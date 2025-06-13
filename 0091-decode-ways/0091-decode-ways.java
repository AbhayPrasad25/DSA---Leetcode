class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo , -1);
        return findWays(s, 0, memo);
    }

    public int findWays(String s, int index, int[] memo) {
        if (index == s.length()) {
            return 1;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int count = findWays(s, index + 1, memo);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            count += findWays(s, index + 2, memo);
        }
        memo[index] = count;
        return count;
    }
}