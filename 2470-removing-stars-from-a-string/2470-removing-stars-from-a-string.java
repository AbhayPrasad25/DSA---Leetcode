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
        StringBuilder s1 = new StringBuilder();
        while(!s.isEmpty()){
            s1.append(s.pop());
        }
        char[] str =  s1.toString().toCharArray();
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