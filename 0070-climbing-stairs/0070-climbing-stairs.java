class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo , -1);
        return backtrackStep(n , 0, memo);
    }
    public int backtrackStep(int n, int step, int[] memo){
        if(step == n){
            return 1;
        }
        if(step > n){
            return 0;
        }
        if(memo[step] != -1){
            return memo[step];
        }
        int ways = 0;
        //we climb with one step at a time
        ways += backtrackStep(n , step + 1, memo);
        //next time we climb with 2 step at a time
        ways += backtrackStep(n , step + 2, memo);
        //store the number of ways for a given number of stairs
        memo[step] = ways;
        return ways;
    }
}