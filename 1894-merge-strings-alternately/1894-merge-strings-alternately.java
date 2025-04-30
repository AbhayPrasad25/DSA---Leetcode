class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str = "";
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < word1.length() && ptr2 < word2.length()){
            str += word1.charAt(ptr1);
            str += word2.charAt(ptr2);
            ptr1++;
            ptr2++;
        }
        while(ptr1 < word1.length()){
            str += word1.charAt(ptr1);
            ptr1++;
        }
        while(ptr2 < word2.length()){
            str += word2.charAt(ptr2);
            ptr2++;
        }
        return str;
    }
}