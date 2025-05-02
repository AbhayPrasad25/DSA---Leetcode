class Solution {
    public int maxVowels(String s, int k) {
        //Optimal Approach
        boolean[] freq = new boolean[26];
        freq['a' - 'a'] = true;
        freq['e' - 'a'] = true;
        freq['i' - 'a'] = true;
        freq['o' - 'a'] = true;
        freq['u' - 'a'] = true;
        int maxVowel = Integer.MIN_VALUE;
        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (freq[ch - 'a']) {
                count++;
            }
            if (right - left + 1 == k) {
                maxVowel = Math.max(maxVowel, count);
                char c = s.charAt(left);
                if (freq[c - 'a']) {
                    count--;
                }
                left++;
            }
        }
        return maxVowel;
    }
}