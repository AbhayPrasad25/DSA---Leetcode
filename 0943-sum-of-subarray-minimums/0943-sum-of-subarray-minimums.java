class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int modulo = (int)1e9 + 7;
        int[] NSE = nse(arr);
        int[] PSE = pse(arr);

        
        // now every element we need to calculate the range and the number of subarray in
        // which it will be minimum

        for(int i = 0; i < arr.length; i++){
            int left = i - PSE[i];
            int right = NSE[i] - i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i]) % modulo);
            sum = (sum + val) % modulo;
        }
        return (int) sum;
    }
    private static int[] pse(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stck = new Stack<>();
        for(int i = 0; i < arr.length;i++){
            while(!stck.isEmpty() && arr[stck.peek()] >= arr[i]){
                stck.pop();
            }
            ans[i] = stck.isEmpty() ? -1 : stck.peek();
            stck.push(i);
        }
        return ans;
    }

    private static int[] nse(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stck = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            while(!stck.isEmpty() && arr[stck.peek()] > arr[i]){
                stck.pop();
            }
            ans[i] = stck.isEmpty() ? arr.length : stck.peek();
            stck.push(i);
        }
        return ans;
    }
}