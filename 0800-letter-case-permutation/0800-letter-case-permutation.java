class Solution {
    public List<String> letterCasePermutation(String s) {
        StringBuilder res = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        permuatation(0, s.length(), res, ans, s);
        return ans;
    }
    private void permuatation(int index , int len , StringBuilder res, List<String> ans, String st){
        //base case
        if(index == len){
            ans.add(res.toString());
            return;
        }
        char c = st.charAt(index);
        if(Character.isLetter(c)){
            //If its lowercase
            res.setCharAt(index, Character.toLowerCase(c));
            permuatation(index + 1, len, res, ans, st);
            //convert to UpperCase()
            res.setCharAt(index, Character.toUpperCase(c));
            permuatation(index + 1, len, res, ans, st);
        }
        else{
            permuatation(index + 1, len, res, ans, st);
        }
    }
}