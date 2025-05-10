class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        //Count the number of zeros based on the number of multiples of 5 ehich are divisible n
        int temp = 5;
        while(temp <= n){
            count += n /temp;
            temp *= 5;
        }
        return count;
    }
}