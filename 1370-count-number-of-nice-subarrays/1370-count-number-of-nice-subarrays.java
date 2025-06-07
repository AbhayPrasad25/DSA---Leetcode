class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int odd = 0;
        map.put(0, 1);
        for(int num : nums){
            if(num % 2 != 0){
                odd++;
            }
            if(map.containsKey(odd - k)){
                count += map.get(odd - k);
            }
            map.put(odd, map.getOrDefault(odd , 0) + 1);
        }
        return count;
    }
}