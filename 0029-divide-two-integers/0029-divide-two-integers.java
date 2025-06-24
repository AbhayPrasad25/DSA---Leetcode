class Solution {
    public int divide(int dividend, int divisor) {
        boolean isPositive = true;
        if(dividend == divisor){
            return 1;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(divisor == 1){
            return dividend;
        }
        if(dividend >= 0 && divisor < 0){
            isPositive = false;
        }
        else if(dividend < 0 && divisor > 0){
            isPositive = false;
        }
        long n  = dividend;
        long d  = divisor;
        n = Math.abs(n);
        d = Math.abs(d);

        long count = 0, sum = 0;
        while(sum + d <= n){
            count += 1;
            sum += d;
        }
        if(count > Integer.MAX_VALUE && isPositive){
            return Integer.MAX_VALUE;
        }
        if(count > Integer.MAX_VALUE && !isPositive){
            return Integer.MIN_VALUE;
        }
        return isPositive ? (int) count : (int)(-1 * count);
    }
}