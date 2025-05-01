class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxCandy = Integer.MIN_VALUE;
        for(int can : candies){
            maxCandy = Math.max(maxCandy , can);
        }
        for(int candy : candies){
            list.add(candy + extraCandies >= maxCandy);
        }
        return list;
    }
}