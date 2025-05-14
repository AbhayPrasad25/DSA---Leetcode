class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        if(pattern.length() != words.length){
            return false;
        }
        HashMap<String , Character> map = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>(); 
        for(int i = 0 ; i < words.length; i++){
            char c = pattern.charAt(i);
            if(!map.containsKey(words[i])){
                map.put(words[i] , c);
            }
            else{
                if(map.get(words[i]) != c){
                    return false;
                }
            }
            if(!map2.containsKey(c)){
                map2.put(c , words[i]);
            }
            else{
                if(!map2.get(c).equals(words[i])){
                    return false;
                }
            }
        }
        return true;
    }
}