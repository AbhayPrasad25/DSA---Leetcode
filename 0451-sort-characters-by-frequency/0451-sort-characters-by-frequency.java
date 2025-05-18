class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder st = new StringBuilder();
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c , 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue().compareTo(a.getValue()));
        for(Map.Entry<Character, Integer> entry : list){
            int val = entry.getValue();
            char c = entry.getKey();
            while(val > 0){
                st.append(c);
                val--;
            }
        }
        return st.toString();
    }
}