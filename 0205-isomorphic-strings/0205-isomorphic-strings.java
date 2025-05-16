class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            char cA = s.charAt(i);
            char tA = t.charAt(i);
            if(!map1.containsKey(cA)){
                map1.put(cA, tA);
            }
            else{
                if(map1.get(cA) != tA){
                    return false;
                }
            }
            if(!map2.containsKey(tA)){
                map2.put(tA, cA);
            }
            else{
                if(map2.get(tA) != cA){
                    return false;
                }
            }
        }
        return true;
    }
}