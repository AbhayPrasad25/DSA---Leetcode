class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        phoneComb(0, digits.length(), digits, res, str, map);
        return res;
    }
    private void phoneComb(int index, int len, String digits, List<String> res, StringBuilder str, HashMap<Integer, String> map){
        if(len == 0){
            return;
        }
        if(index >= len){
            res.add(str.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for(char c : map.get(digit).toCharArray()){
            str.append(c);
            phoneComb(index + 1, len, digits, res, str, map);
            str.deleteCharAt(str.length() - 1);
        }
    }
}