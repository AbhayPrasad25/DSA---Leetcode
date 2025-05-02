class Solution {
    public int maxOperations(int[] nums, int k) {
        // Optimal Approach using HashMap and finding the complement
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int operation = 0;
        for (int i = 0; i < nums.length; i++) {
            int el = k - nums[i];
            if (el == nums[i] && map.containsKey(el) && map.get(el) >= 2) {
                map.put(el, map.getOrDefault(el, 0) - 2);
                operation++;
            } else if (el != nums[i] && map.containsKey(el) && map.get(el) > 0 && map.get(nums[i]) > 0) {
                map.put(el, map.getOrDefault(el, 0) - 1);
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                operation++;
            }
        }
        return operation;
    }
}