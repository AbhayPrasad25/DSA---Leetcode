class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if(power < 0){
            x = 1/x;
            power *= -1;
        }
        return helpPower(x , power);
    }
    private double helpPower(double x , long pow){
        if(pow == 0){
            return 1.0;
        }
        double half = helpPower(x , pow/2);
        double res = half * half;
        if(pow % 2 == 1){
            res = res * x;
        }
        return res;
    }
}