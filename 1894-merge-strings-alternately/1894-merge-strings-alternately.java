class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int ptr = 0;
        while(ptr < word1.length() && ptr < word2.length()){
            str.append(word1.charAt(ptr));
            str.append(word2.charAt(ptr));
            ptr++;
        }
        while(ptr < word1.length()){
            str.append(word1.charAt(ptr));
            ptr++;
        }
        while(ptr < word2.length()){
            str.append(word2.charAt(ptr));
            ptr++;
        }
        return str.toString();
    }
}