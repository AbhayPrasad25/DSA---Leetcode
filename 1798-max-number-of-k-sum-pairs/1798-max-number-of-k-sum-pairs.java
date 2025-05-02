class Solution {
    public int maxOperations(int[] nums, int k) {
        // Optimal Approach using HashMap and finding the complement
        HashMap<Integer, Integer> map = new HashMap<>();
        int operation = 0;
        for(int num : nums){
            int comp = k - num;
            if(map.getOrDefault(comp, 0) > 0){
                operation++;
                map.put(comp , map.getOrDefault(comp , 0) - 1);
            }
            else{
                map.put(num , map.getOrDefault(num , 0) + 1);
            }
        }
        return operation;
    }
}