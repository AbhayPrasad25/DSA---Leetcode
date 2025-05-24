class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String wrd = words[i];
            int index = 0;
            for(char c : wrd.toCharArray()){
                if(c == x){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}