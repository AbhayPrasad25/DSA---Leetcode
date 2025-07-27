class Solution {
    public int trap(int[] height) {
        int[] PGH = pgh(height);
        int[] NGH = ngh(height);
        int rainwater = 0;
        for(int i = 0; i < height.length; i++){
            rainwater += Math.max(0, Math.min(PGH[i], NGH[i]) - height[i]);
        }
        return rainwater;
    }
    public static int[] ngh(int[] height){
        Stack<Integer> stck = new Stack<>();
        int[] NGH = new int[height.length];
        int maxh = height[height.length - 1];
        for(int i = height.length - 1; i >= 0; i--){
            while(!stck.isEmpty() && stck.peek() < height[i]){
                stck.pop();
            }
            NGH[i] = stck.isEmpty() ? 0 : stck.peek();
            maxh = Math.max(maxh, height[i]);
            stck.push(maxh);
        }
        return NGH;
    }
    public static int[] pgh(int[] height){
        Stack<Integer> stck = new Stack<>();
        int[] PGH = new int[height.length];
        int maxh = height[0];
        for(int i = 0; i < height.length; i++){
            while(!stck.isEmpty() && stck.peek() < height[i]){
                stck.pop();
            }
            PGH[i] = stck.isEmpty() ? 0 : stck.peek();
            maxh = Math.max(maxh, height[i]);
            stck.push(maxh);
        }
        return PGH;
    }
}