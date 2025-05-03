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
        double res = 1;
        while(pow > 0){
            if(pow % 2 == 1){
                res *= x;
            }
            x *= x;
            pow /= 2;
        }
        return res;
    }
}