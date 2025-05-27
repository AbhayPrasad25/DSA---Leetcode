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
        StringBuilder str = new StringBuilder(String.valueOf(n));
        String st = str.reverse().toString();
        int n2 = Integer.parseInt(st);
        return (n + n2) == num;
    }
}