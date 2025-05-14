class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqA = new int[26];
        for(char c : magazine.toCharArray()){
            freqA[c - 'a']++;
        }
        int[] freqB = new int[26];
        for(char c : ransomNote.toCharArray()){
            freqB[c - 'a']++;
            if(freqB[c - 'a'] > freqA[c - 'a']){
                return false;
            }
        }
        return true;
    }
}