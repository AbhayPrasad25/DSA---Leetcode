class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostDistinct(nums, k) - atmostDistinct(nums, k - 1);
    }
    private int atmostDistinct(int[] nums, int k){
        int left = 0, right = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(left <= right && map.size() > k){
                map.put(nums[left], map.getOrDefault(nums[left] , 0) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}