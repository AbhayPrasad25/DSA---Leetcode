class Solution {
    public void nextPermutation(int[] nums) {
        //The first decreasing element is the pivot element 
        int pivot = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                pivot = i-1;
                break;
            }
        }
        // there is no pivot means the array is in deceneding order so we reverse it 
        if(pivot == -1){
            reverse(nums, 0);
            return;
        }
        // after finding the pivot we swap with the smallest larger to the right
        int index = -1;
        for(int i = nums.length - 1; i > pivot; i--){
            if(nums[i] > nums[pivot]){
                index = i;
                break;
            }
        }
        //Swapping the number 
        if(index != -1){
            int temp = nums[pivot];
            nums[pivot] = nums[index];
            nums[index] = temp;
        }
        reverse(nums, pivot + 1);
    }
    private static void reverse(int[] nums, int index){
        int right = nums.length - 1;
        int left = index;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}