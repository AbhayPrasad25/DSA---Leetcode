class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqA = new int[26];
        for(char c : magazine.toCharArray()){
            freqA[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            freqA[c - 'a']--;
            if(freqA[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}