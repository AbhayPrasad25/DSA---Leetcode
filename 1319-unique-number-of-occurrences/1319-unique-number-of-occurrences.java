class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr){
            set.add(a);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int a: set){
            int count = 0;
            for(int ar : arr){
                if(a == ar){
                    count++;
                }
            }
            if(set2.contains(count)){
                return false;
            }
            else{
                set2.add(count);
            }
        }
        return true;
    }
}