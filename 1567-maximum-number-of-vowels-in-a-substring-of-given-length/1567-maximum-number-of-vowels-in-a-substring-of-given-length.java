class Solution {
    public int maxVowels(String s, int k) {
        //Optimal Approach
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int maxVowel = Integer.MIN_VALUE;
        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                count++;
            }
            if (right - left + 1 == k) {
                maxVowel = Math.max(maxVowel, count);
                if (set.contains(s.charAt(left))) {
                    count--;
                }
                left++;
            }
        }
        return maxVowel;
    }
}