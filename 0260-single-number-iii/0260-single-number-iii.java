class Solution {
    public int[] singleNumber(int[] nums) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num , 0) + 1);
        }
        int i = 0;
        for(var entry : map.entrySet()){
            if(entry.getValue() == 1){
                arr[i++] = entry.getKey();
            }
        }
        return arr;
    }
}