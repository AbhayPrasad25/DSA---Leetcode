class Solution {
    public boolean checkPerfectNumber(int num) {
        int i = 1;
        int sum = 0;
        while(i < num){
            if(num % i == 0){
                sum += i;
            }
            i++;
        }
        return sum == num;
    }
}