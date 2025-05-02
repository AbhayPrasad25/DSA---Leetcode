class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        for (int i = 0; i < str2.length(); i++) {
            String pref = str2.substring(0, i + 1);
            int len = i + 1;
            if (str1.length() % len != 0 || str2.length() % len != 0) {
                continue;
            }
            boolean valid = true;
            for (int j = 0; j < str2.length(); j += len) {
                if (!str2.substring(j, j + len).equals(pref)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                for (int j = 0; j < str1.length(); j += len) {
                    if (!str1.substring(j, j + len).equals(pref)) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                res = pref;
            }
        }
        return res;
    }
}