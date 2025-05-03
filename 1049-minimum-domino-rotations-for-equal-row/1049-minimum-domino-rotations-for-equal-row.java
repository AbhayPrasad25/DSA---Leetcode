class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int candidate1 = tops[0];
        int candidate2 = bottoms[0];
        int min1 = count(tops, bottoms, candidate1);
        int min2 = count(bottoms, tops, candidate1);
        int min3 = count(bottoms, tops, candidate2);
        int min4 = count(tops, bottoms, candidate2);
        int min12 = Math.min(min1, min2);
        int min34 = Math.min(min3, min4);
        int min = Math.min(min12, min34);
        return (min == Integer.MAX_VALUE? -1 : min);
    }
    private int count(int[] top, int[] bottom, int el){
        int cnt = 0;
        for(int i = 0; i < top.length; i++){
            if(bottom[i] == el && top[i] != el){
                cnt++;
            }
            else if(bottom[i] != el && top[i] != el){
                return Integer.MAX_VALUE;
            }
        }
        return cnt; 
    }
}