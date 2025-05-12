class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*' && !st.isEmpty()){
                str.deleteCharAt(st.size() - 1);
                st.pop();
            }
            else{
                st.push(c);
                str.append(c);
            }
        }
        return str.toString();
    }
    
}