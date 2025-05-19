class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int ptr1 = a.length() - 1, ptr2 = b.length() - 1;
        StringBuilder str = new StringBuilder();
        while(ptr1 >= 0 || ptr2 >= 0 || carry != 0){
            int sum = carry;
            if(ptr1 >= 0){
                sum += a.charAt(ptr1) - '0';
                ptr1--;
            }
            if(ptr2 >= 0){
                sum += b.charAt(ptr2) - '0';
                ptr2--;
            }
            str.append(sum % 2);
            carry = sum/2;
        }
        return str.reverse().toString();
    }
}