class Solution {
    public long subArrayRanges(int[] nums) {
        int[] pge = PGE(nums);
        int[] nge = NGE(nums);
        int[] nse = NSE(nums);
        int[] pse = PSE(nums);

        long maxSum = 0;
        for(int i = 0; i < nums.length; i++){
            long left = i - pge[i];
            long right = nge[i] - i;
            long subarray = left * right;
            long sum = subarray * nums[i];
            maxSum += sum;
        }

        long minSum = 0;
        for(int i = 0; i < nums.length; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            long subarray = left * right;
            long sum = subarray * nums[i];
            minSum += sum;
        }
        return maxSum - minSum;
    }
    //first we will find the sbaraay maximum sum 
    public int[] PGE(int[] nums){
        Stack<Integer> stck = new Stack<>();
        int[] nge = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while(!stck.isEmpty() && nums[stck.peek()] < nums[i]){
                stck.pop();
            }
            nge[i] = stck.isEmpty() ? -1 : stck.peek();
            stck.push(i);
        }
        return nge;
    }

    public int[] NGE(int[] nums){
        int n = nums.length;
        Stack<Integer> stck = new Stack<>();
        int[] nge = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stck.isEmpty() && nums[stck.peek()] <= nums[i]){
                stck.pop();
            }
            nge[i] = stck.isEmpty() ? n : stck.peek();
            stck.push(i);
        }
        return nge;
    }

    public int[] PSE(int[] nums){
        int n = nums.length;
        Stack<Integer> stck = new Stack<>();
        int[] nge = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while(!stck.isEmpty() && nums[stck.peek()] > nums[i]){
                stck.pop();
            }
            nge[i] = stck.isEmpty() ? -1 : stck.peek();
            stck.push(i);
        }
        return nge;
    }
    public int[] NSE(int[] nums){
        int n = nums.length;
        Stack<Integer> stck = new Stack<>();
        int[] nge = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stck.isEmpty() && nums[stck.peek()] >= nums[i]){
                stck.pop();
            }
            nge[i] = stck.isEmpty() ? n : stck.peek();
            stck.push(i);
        }
        return nge;
    }

}