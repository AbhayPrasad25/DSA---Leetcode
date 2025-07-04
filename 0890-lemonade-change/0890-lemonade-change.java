class Solution {
    public boolean lemonadeChange(int[] bills) {
        int left = 0;
        int ten = 0;
        int five = 0;
        while(left < bills.length){
            int amount = bills[left];
            int change = amount - 5;
            if(amount == 5){
                five++;
            }
            else if(amount == 10){
                if(five > 0){
                    five--;
                    ten++;
                }
                else{
                    return false;
                }
            }
            else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }
                else if(five >= 3){
                    five-=3;
                }
                else{
                    return false;
                }
            }
            left++;
        }
        return true;
    }
}