class Solution {
    public int compress(char[] chars) {
        //First With Extra Space
        StringBuilder str = new StringBuilder();
        char c1 = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c1 != c) {
                str.append(c1);
                if(count != 1){
                    str.append(count);
                }
                count = 1;
                c1 = c;
            } else {
                count++;
            }
        }
        if(count == 1){
            str.append(c1);
        }
        else{
            str.append(c1);
            str.append(count);
        }
        String s = str.toString();
        for(int i = 0; i < s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}
