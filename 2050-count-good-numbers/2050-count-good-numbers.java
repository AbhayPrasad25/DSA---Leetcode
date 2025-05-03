class Solution {
    public int countGoodNumbers(long n) {
        int modulo_amt = 1000000007;
        long even_count = (n + 1)/2;
        long odd_count = n /2;
        long even = fastcomput(5, even_count, modulo_amt);
        long odd = fastcomput(4, odd_count, modulo_amt);
        return (int)((even * odd) % modulo_amt);
    }
    private long fastcomput(long base, long exp, int modulo_amt){
        if(exp == 0){
            return 1;
        }
        long half = fastcomput(base, exp/2, modulo_amt);
        long result = (half * half) % modulo_amt;
        if(exp % 2 == 1){
            result = (result * base) % modulo_amt;
        }
        return result;
    }
}