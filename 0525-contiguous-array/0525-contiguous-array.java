class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, sum = 0;
        map.put(0 , -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum -= 1;
            }
            else{
                sum += 1;
            }
            if(map.containsKey(sum)){
                max = Math.max(i - map.get(sum), max);
            }
            else{
                map.put(sum , i);
            }
        }
        return max;
    }
}