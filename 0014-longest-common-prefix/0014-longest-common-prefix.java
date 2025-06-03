class Solution {
    public String longestCommonPrefix(String[] strs) {
        String small = smallest(strs);
        StringBuilder st = new StringBuilder();
        int size = 0;
        for(int i = 0; i < small.length(); i++){
            boolean found = true;
            for(String str : strs){
                if(str.charAt(i) != small.charAt(i)){
                    found = false;
                    break;
                }
            }
            if(!found){
                break;
            }
            st.append(small.charAt(i));
        }
        return st.toString();
    }
    private String smallest(String[] strs){
        int size = strs[0].length();
        String res = strs[0];
        for(String str : strs){
            int curSize = str.length();
            if(curSize < size){
                res = str;
                size = curSize;
            }
        }
        return res;
    }
}