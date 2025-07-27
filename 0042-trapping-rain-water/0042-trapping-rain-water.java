class Solution {
    public int trap(int[] height) {
        int left = 0, maxhL = 0, maxhR = 0;
        int right = height.length - 1;
        int trapped = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(maxhL >= height[left]){
                    trapped += (maxhL - height[left]);
                }
                else{
                    maxhL = Math.max(maxhL , height[left]);
                }
                left++;
            }
            else{
                if(maxhR >= height[right]){
                    trapped += (maxhR - height[right]);
                }
                else{
                    maxhR = Math.max(maxhR, height[right]);
                }
                right--;
            }
        }
        return trapped;
    }
}