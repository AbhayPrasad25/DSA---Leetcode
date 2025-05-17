class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        int n = nums.length;
        for(int i = 0; i <= n - k; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < i+k; j++){
               set.add(nums[j]);
            }
            for(int s : set){
                 map.put(s , map.getOrDefault(s , 0) + 1);
            }
        }
        for(var entry: map.entrySet()){
            if(entry.getValue() == 1){
                max = Math.max(entry.getKey() , max);
            }
        }
        return max;
    }
}