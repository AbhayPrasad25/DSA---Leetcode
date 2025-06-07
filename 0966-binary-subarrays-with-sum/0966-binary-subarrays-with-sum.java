class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pref = 0;
        int count = 0;
        for(int num : nums){
            pref += num;
            if(map.containsKey(pref - goal)){
                count += map.get(pref - goal);
            }
            map.put(pref, map.getOrDefault(pref, 0) + 1);
        }
        return count;
    }
}