class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()){
            return "0";
        }
        Stack<Character> stck = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(!stck.isEmpty() && k > 0 && stck.peek() - '0' > ch - '0'){
                stck.pop();
                k--;
            }
            stck.push(ch);
        }
        //still there are digits needed we need to remove
        while(k > 0){
            stck.pop();
            k--;
        }
        if(stck.isEmpty()){
            return "0";
        }
        StringBuilder str = new StringBuilder();
        while(!stck.isEmpty()){
            str.append(stck.pop());
        }
        //remove the starting zero
        while(str.length() > 1 && str.charAt(str.length() - 1) == '0'){
            str.deleteCharAt(str.length() - 1);

        }
        return str.reverse().toString();
    }
}