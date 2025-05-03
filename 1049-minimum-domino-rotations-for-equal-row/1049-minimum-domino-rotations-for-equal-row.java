class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minimum = countRotation(tops, bottoms , tops[0]);
        if(minimum != - 1) return minimum;
        return countRotation(tops, bottoms, bottoms[0]);
    }
    private int countRotation(int[] top, int[] bottom, int el){
        int rotateTop = 0;
        int rotateBottom = 0;
        for(int i = 0; i < top.length; i++){
            if(top[i] != el && bottom[i] != el){
                return -1;
            }
            else if(top[i] != el){
                rotateTop++;
            }
            else if(bottom[i] != el){
                rotateBottom++;
            }
        }
        return Math.min(rotateTop, rotateBottom); 
    }
}