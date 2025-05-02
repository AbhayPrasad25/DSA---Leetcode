class Solution {
    public int maxVowels(String s, int k) {
        //Optimal Approach
        int maxVowel = Integer.MIN_VALUE;
        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == 'a' || s.charAt(right) == 'e' || s.charAt(right) == 'i' || s.charAt(right) == 'o'
                    || s.charAt(right) == 'u') {
                count++;
            }
            if (right - left + 1 == k) {
                maxVowel = Math.max(maxVowel, count);
                if (s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' || s.charAt(left) == 'o'
                        || s.charAt(left) == 'u') {
                    count--;
                }
                left++;
            }
        }
        return maxVowel;
    }
}