class Solution {
    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        return backtrack(1, used, n);
    }
    public int backtrack(int index, boolean[] used, int n){
        if(index > n){
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(!used[i] && (i % index == 0 || index % i == 0)){
                used[i] = true;
                count += backtrack(index + 1, used, n);
                used[i] = false;
            }
        }
        return count;
    }
}