class Solution {
    public boolean lemonadeChange(int[] bills) {
        int left = 0;
        int twenty = 0;
        int ten = 0;
        int five = 0;
        while(left < bills.length){
            int amount = bills[left];
            int change = amount - 5;
            if(amount == 5){
                five++;
            }
            else if(amount == 10){
                ten++;
            }
            else{
                twenty++;
            }
            int right = 2;
            while(change >= 20 && twenty > 0){
                change -= 20;
                twenty--;
            }
            while(change >= 10 && ten > 0){
                change -= 10;
                ten--;
            }
            while(change >= 5 && five > 0){
                change -= 5;
                five--;
            }
            if(change != 0){
                return false;
            }
            left++;
        }
        return true;
    }
}