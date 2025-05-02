class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch : word1.toCharArray()){
            map1.put(ch , map1.getOrDefault(ch , 0) + 1);
        }
        // Now checking for unique values while updating the HashMap map 2
        for(char ch : word2.toCharArray()){
            if(!map1.containsKey(ch)){
                return false;
            }
            map2.put(ch , map2.getOrDefault(ch , 0) + 1);
        }
        List<Integer> list1 = count(map1);
        List<Integer> list2 = count(map2);
        return checkEqual(list1, list2); 
    }
    private List<Integer> count(HashMap<Character, Integer> map1){
        return new ArrayList<>(map1.values());
    }
    private boolean checkEqual(List<Integer> list1 , List<Integer> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    } 
}