class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num1 = st.pop();
                int num2 = st.pop();
                int val = operation(tokens[i], num1 , num2); 
                st.push(val);
            }
            else{
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        return st.pop();
    }
    private int operation(String s , int num1 , int num2){
        if(s.equals("+")){
            return num2 + num1; 
        }
        else if(s.equals("-")){
            return num2 - num1;
        }
        else if(s.equals("/")){
            return num2 / num1;
        }
        return num2 * num1;
    }
}