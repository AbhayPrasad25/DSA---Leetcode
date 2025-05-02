class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char ch : word1.toCharArray()){
            freq1[ch - 'a']++;
        }
        // Now checking for unique values while updating the HashMap map 2
        for(char ch : word2.toCharArray()){
            if(freq1[ch - 'a'] == 0){
                return false;
            }
            freq2[ch - 'a']++;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2); 
    }
}