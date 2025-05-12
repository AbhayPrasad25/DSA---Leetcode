class Solution {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int highest = 0;
        for (int alt : gain) {
            start += alt;
            highest = Math.max(highest, start);
        }
        return highest;
    }
}