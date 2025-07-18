class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stck = new Stack<>();
        for(int i = n - 1; i>= 0; i--){
            while(!stck.isEmpty() && stck.peek() <= nums[i]){
                stck.pop();
            }
            stck.push(nums[i]);
        }
        //second pass
        for(int i = n - 1; i >= 0; i--){
            while(!stck.isEmpty() && stck.peek() <= nums[i]){
                stck.pop();
            }
            //if stck is Empty that means there is no element greater than it so addd -1
            if(stck.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stck.peek();
            }
            stck.push(nums[i]);
        }
        return ans;
    }
}