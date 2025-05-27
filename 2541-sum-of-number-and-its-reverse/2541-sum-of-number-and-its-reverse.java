class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        //first converting the number into string and then reversing it 
        for(int i = num/2; i <= num; i++){
            if(check(i , num)){
                return true;
            }
        }
        return false;
    }
    private boolean check(int n, int num){
        int rev = reverse(n);
        return (n + rev) == num;
    }
    private int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev * 10 + num % 10;
            num/=10;
        }
        return rev;
    }
}