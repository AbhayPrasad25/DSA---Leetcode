class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '*'){
                str.deleteCharAt(str.length() - 1);
            }
            else{
                str.append(c);
            }
        }
        return str.toString();
    }
    
}