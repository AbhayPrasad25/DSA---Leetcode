class Solution {
    public int compress(char[] chars) {
        //Without Extra Space
        int indexPtr = 0;
        char c1 = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c1 != c) {
                chars[indexPtr++] = c1;
                if (count != 1) {
                    for (char ch : String.valueOf(count).toCharArray()) {
                        chars[indexPtr++] = ch;
                    }
                }
                c1 = c;
                count = 1;
            } else {
                count++;
            }
        }
        chars[indexPtr++] = c1;
        if (count != 1) {
            for (char ch : String.valueOf(count).toCharArray()) {
                chars[indexPtr++] = ch;
            }
        }
        return indexPtr;
    }
}