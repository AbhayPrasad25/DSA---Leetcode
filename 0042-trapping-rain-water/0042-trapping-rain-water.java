class Solution {
    public int trap(int[] height) {
        int left = 0, maxhL = 0, maxhR = 0;
        int right = height.length - 1;
        int trapped = 0;
        while(left < right){
            if(height[left] <= height[right]){
                trapped += Math.max(0, maxhL - height[left]);
                maxhL = Math.max(maxhL, height[left]);
                left++;
            }
            else{
                trapped += Math.max(0, maxhR - height[right]);
                maxhR = Math.max(maxhR, height[right]);
                right--;
            }
        }
        return trapped;
    }
}