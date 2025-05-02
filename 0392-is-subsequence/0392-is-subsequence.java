class Solution {
    public boolean isSubsequence(String s, String t) {
        int ptrA = 0;
        for(char subT : t.toCharArray()){
            if(ptrA < s.length() && s.charAt(ptrA) == subT){
                ptrA++;
            }
        }
        return ptrA == s.length();
    }
}