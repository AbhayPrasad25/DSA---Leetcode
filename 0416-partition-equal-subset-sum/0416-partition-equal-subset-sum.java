class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int targetsum = 0;
        for(int i : arr){
            targetsum += i;
        }
        if(targetsum % 2 != 0){
            return false;
        }
        targetsum /= 2;
        boolean[] prev = new boolean[targetsum + 1];
        prev[0] = true;
        if(arr[0] <= targetsum){
            prev[arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[targetsum + 1];
            //marking the first as true
            curr[0] = true;
            for(int j = 1; j <= targetsum; j++){
                boolean take = false;
                if(arr[i] <= j){
                    take = prev[j - arr[i]];
                }
                boolean notTaken = prev[j];
                curr[j] = take|| notTaken;
            }
            //putting the valuies in the prev to keep track of previous row 
            prev = curr;
        }
        return prev[targetsum];
    }
    public boolean equalSubset(int index, int[] arr, int sum1, Boolean[][] dp){
        if(index == 0){
            return sum1 == 0 || sum1 - arr[index] == 0;
        }
        if(sum1 == 0){
            return true;
        }
        if(dp[index][sum1] != null){
            return dp[index][sum1];
        }
        boolean take = false;
        if(arr[index] <= sum1){
            take = equalSubset(index - 1, arr, sum1 - arr[index],dp);
        }
        boolean notTaken = equalSubset(index - 1, arr, sum1, dp);
        dp[index][sum1] = take || notTaken;
        return dp[index][sum1];
    }
}