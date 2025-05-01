class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            int candy = candies[i] + extraCandies;
            list.add(checkGreatest(candies , candy));
        }
        return list;
    }
    private boolean checkGreatest(int[] candies, int amount){
        for(int n : candies){
            if(amount < n){
                return false;
            }
        }
        return true;
    }
}