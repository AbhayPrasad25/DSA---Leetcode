class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stck = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stck.push(0);
            }
            else{
                int top = stck.pop();
                int score = (top == 0 ? 1 : 2 * top);
                int prev = 0;
                if(!stck.isEmpty()){
                    prev = stck.pop();
                }
                stck.push(prev + score);
            }
        }
        return stck.pop();
    }
}