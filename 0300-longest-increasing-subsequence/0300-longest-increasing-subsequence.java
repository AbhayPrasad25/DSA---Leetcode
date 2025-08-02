class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        int len = 1;
        for(int i = 0; i < nums.length; i++){
            if(lis.get(lis.size() - 1) < nums[i]){
                lis.add(nums[i]);
                len++;
            }
            else{
                int Index = binarySearch(lis, nums[i]);
                lis.set(Index, nums[i]);
            }
        }
        return len;
    }
    public static int binarySearch(List<Integer> lis, int el){
        int left = 0;
        int right = lis.size() - 1;
        int index = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(lis.get(mid) >= el){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}