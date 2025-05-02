class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char ch : word1.toCharArray()){
            freq1[ch - 'a']++;
        }
        // Now checking for unique values while updating the HashMap map 2
        for(char ch : word2.toCharArray()){
            if(freq1[ch - 'a'] == 0){
                return false;
            }
            freq2[ch - 'a']++;
        }
        List<Integer> list1 = count(freq1);
        List<Integer> list2 = count(freq2);
        return checkEqual(list1, list2); 
    }
    private List<Integer> count(int[] freq){
        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                count.add(freq[i]);
            }
        }
        return count;
    }
    private boolean checkEqual(List<Integer> list1 , List<Integer> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    } 
}