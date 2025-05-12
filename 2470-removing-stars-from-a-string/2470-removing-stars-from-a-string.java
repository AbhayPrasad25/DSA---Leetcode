class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*' && !st.isEmpty()){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        return reverseString(st);
    }
    private String reverseString(Stack<Character> s){
        String string = "";
        while(!s.isEmpty()){
            string += s.pop();
        }
        char[] str =  string.toCharArray();
        int left = 0;
        int right = str.length - 1;
        while(left < right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(str);
    }
}