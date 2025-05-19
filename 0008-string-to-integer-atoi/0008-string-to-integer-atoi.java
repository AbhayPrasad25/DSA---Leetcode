class Solution {
    public int myAtoi(String s) {
        long num = 0;
        s = s.trim();
        int ptr = 0;
        boolean isNeg = false;
        //check if the current ptr is '-'
        if(ptr < s.length() && s.charAt(ptr) != '0'){
            if(s.charAt(ptr) == '-'){
                isNeg = true;
                ptr++;
            }
            else if(s.charAt(ptr) == '+'){
                ptr++;
            }
        }
        //Skip trailing zeros
        while(ptr < s.length() && s.charAt(ptr) == '0'){
            ptr++;
        }
        while(ptr < s.length() && Character.isDigit(s.charAt(ptr))){
            long curNum = s.charAt(ptr) - '0';
            if(num * 10 + curNum > Integer.MAX_VALUE){
                if(isNeg){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            num = (num * 10) + curNum;
            ptr++;
        }
        if(isNeg){
            return (int)num * -1;
        }
        return (int) num;
    }
}