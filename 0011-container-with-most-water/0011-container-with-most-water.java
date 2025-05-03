class Solution {
    public int maxArea(int[] height) {
        //In this approach we only upadte the min height when the height is larger than the min heigth
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            while(left < right && height[left] <= minHeight){
                left++;
            }
            while(left < right && height[right] <= minHeight){
                right--;
            }

        }
        return maxArea;
    }
}