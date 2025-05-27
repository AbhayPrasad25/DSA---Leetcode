class Solution {
    public int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1)/2;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(i % m != 0){
                sum += i;
            }
        }
        return sum - (totalSum - sum);
    }
}