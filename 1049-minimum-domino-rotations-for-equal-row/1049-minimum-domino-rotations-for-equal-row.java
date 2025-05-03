class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int candidate1 = tops[0];
        int candidate2 = bottoms[0];
        int rotations1 = Math.min(count(tops, bottoms, candidate1), count(bottoms, tops, candidate1));
        int rotations2 = Math.min(count(tops, bottoms, candidate2), count(bottoms, tops, candidate2));

        int minRotations = Math.min(rotations1, rotations2);
        return (minRotations == Integer.MAX_VALUE) ? -1 : minRotations;
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