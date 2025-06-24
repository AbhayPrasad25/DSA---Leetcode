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
        int count = 0;
        long n = dividend;
        long d = divisor;

        n = Math.abs(n);
        d = Math.abs(d);
        
        while(n >= d){
            int cnt = 0;
            while(n >= (d << (cnt + 1))){
                cnt++;
            }
            count += 1 << cnt;
            n -= d << cnt;
        }

        if(count == (1 << 31) && isPositive){
            return Integer.MAX_VALUE;
        }
        if(count == (1 << 31) && !isPositive){
            return Integer.MIN_VALUE;
        }
        return isPositive ? count : -1 * count;
    }
}