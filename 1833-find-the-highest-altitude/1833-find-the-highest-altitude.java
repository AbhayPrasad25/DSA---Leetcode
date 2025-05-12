class Solution {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int highest = 0;
        for(int alt : gain){
            highest = Math.max(highest, start);
            start += alt;
        }
        return Math.max(highest, start);
    }
}