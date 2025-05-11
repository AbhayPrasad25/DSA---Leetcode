class Solution {
    public int longestConsecutive(int[] nums) {
        //Brute force 
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currentNum = n;
                int len = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}