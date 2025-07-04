class Solution {
    public boolean lemonadeChange(int[] bills) {
        int left = 0;
        int[] balance =  new int[3];
        while(left < bills.length){
            int amount = bills[left];
            int change = amount - 5;
            if(amount == 5){
                balance[0]++;
            }
            else if(amount == 10){
                balance[1]++;
            }
            else{
                balance[2]++;
            }
            int right = 2;
            while(right >= 0){
                if(right == 2){
                    while(change >= 20 && balance[right] > 0){
                        change -= 20;
                        balance[right]--;
                    }
                }
                else if(right == 1){
                    while(change >= 10  && balance[right] > 0){
                        change -= 10;
                        balance[right]--;
                    }
                }
                else{
                    while(change >= 5 && balance[right] > 0){
                        change -= 5;
                        balance[right]--;
                    }
                }
                right--;
            }
            if(change != 0){
                return false;
            }
            left++;
        }
        return true;
    }
}