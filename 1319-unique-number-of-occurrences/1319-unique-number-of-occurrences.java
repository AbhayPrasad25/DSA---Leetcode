class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //Usinga a HashMap and HashSet to find if the array has uniqueOccurences or not 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a , map.getOrDefault(a , 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(var entry : map.entrySet()){
            if(set.contains(entry.getValue())){
                return false;
            }
            else{
                set.add(entry.getValue());
            }
        }
        return true;
    }
}