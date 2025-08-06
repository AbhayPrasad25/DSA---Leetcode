class KthLargest {
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        int i = 0;
        while(i < nums.length && i < k){
            minHeap.add(nums[i]);
            i++;
        }
        while(i < nums.length){
            if(minHeap.peek() < nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
            i++;
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > K){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */