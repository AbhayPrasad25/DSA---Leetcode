class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stck = new ArrayDeque<>();
        int n = asteroids.length;
        for(int i = 0; i < n; i++){
            if(asteroids[i] > 0){
                stck.push(asteroids[i]);
            }
            else{
                while(!stck.isEmpty() && stck.peek() > 0 && Math.abs(asteroids[i]) > stck.peek()){
                stck.pop();
                }
                boolean destroyed = false;
                if(!stck.isEmpty() && stck.peek() > 0){
                    if(Math.abs(asteroids[i]) == stck.peek()){
                        stck.pop();
                    }
                    destroyed = true;
                }
                if(!destroyed){
                    stck.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[stck.size()];
        for(int i = stck.size() - 1; i >= 0; i--){
            ans[i] = stck.pop();
        }
        return ans;
    }
}