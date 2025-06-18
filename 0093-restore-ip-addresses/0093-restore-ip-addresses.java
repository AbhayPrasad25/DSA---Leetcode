class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(ans, res, s, 0);
        return res;
    }
    public void backtrack(List<String> ans, List<String> res, String s, int index){
        if(s.length() > 12){
            return;
        }
        if(index == s.length() && ans.size() == 4){
            String st = String.join(".", ans);
            res.add(st);
            return;
        }
        for(int end = 1; end <= 3 && end + index <= s.length(); end++){
            int num = Integer.parseInt(s.substring(index , index + end));
            if( num <= 255){
                if(s.charAt(index) == '0' && end == 1 || s.charAt(index) != '0'){
                    ans.add(s.substring(index, index + end));
                    backtrack(ans, res, s, index + end);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
}