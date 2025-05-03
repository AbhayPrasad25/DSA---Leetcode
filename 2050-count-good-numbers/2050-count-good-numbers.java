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
        long res = 1;
        while(exp > 0){
            if(exp % 2 == 1){
                res = (res * base) % modulo_amt;
            }
            base = (base * base) % modulo_amt;
            exp /= 2;
        }
        return res % modulo_amt;
    }
}