class Solution {
    public int findKthLargest(int[] nums, int k) {
        //do heapify down on all the innerNodes;
        //build a maxHeap 
        int n = nums.length;
        int last = nums.length - 1;
        for(int i = (n / 2) - 1; i >= 0; i--){
            HeapifyDown(nums, last, i);
        }
        while(k > 1){
            swap(nums, 0 , last);
            // Imagine that the last element is not included in the maxHeap and try to find the next max
            last--;
            HeapifyDown(nums, last, 0);
            k--;
        }
        return nums[0];
    }
    public static void HeapifyDown(int[] nums,int last, int index){
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;
        while(leftChild <= last && nums[leftChild] > nums[largest]){
            largest = leftChild;
        }
        while(rightChild <= last && nums[rightChild] > nums[largest]){
            largest = rightChild;
        }
        if(largest != index){
            swap(nums, index, largest);
            HeapifyDown(nums,last, largest);
        }
    }
    public static void swap(int[] nums , int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}