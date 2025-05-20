class Solution {
    public int countGoodNumbers(long n) {
        long modulo = 1000000007;
        long num = n;
        long evenIndex = (n + 1)/2;
        long oddIndex = n/2;
        //Now we need to find the total number of possible solution for each index;
        long evenres = exponentiation(5, evenIndex, modulo);
        long oddres = exponentiation(4, oddIndex, modulo);
        return (int)((evenres * oddres) % modulo);
    }
    //Modular Arithmetic
    private long exponentiation(long base, long count, long modulo){
        //Base Case
        if(count == 0){
            return 1;
        }
        long power = exponentiation(base , count/2, modulo);
        long res = (power * power) % modulo;
        if(count % 2 != 0){
            res *= base;
            res %= modulo;
        }
        return res;
    }

}